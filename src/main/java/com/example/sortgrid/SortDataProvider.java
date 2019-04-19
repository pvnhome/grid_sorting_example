package com.example.sortgrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.QuerySortOrder;

/**
 * <p><b>Created:</b> 16.04.2019 23:33:22</p>
 * @author victor
 */
@SuppressWarnings("serial")
public class SortDataProvider extends AbstractBackEndDataProvider<SortDTO, SortFilterDTO> {
   private static final int COUNT = 200;

   private Logger log = LoggerFactory.getLogger(SortDataProvider.class.getName());

   private static final List<SortDTO> R;
   private static final List<SortDTO> O;


   @Override
   protected Stream<SortDTO> fetchFromBackEnd(Query<SortDTO, SortFilterDTO> query) {
      int offset = query.getOffset();
      int limit = query.getLimit();

      Optional<SortFilterDTO> filter = query.getFilter();
      List<QuerySortOrder> sortOrders = query.getSortOrders();
      
      String sortDesc = formatSortDesc(sortOrders);

      log.info("fetchFromBackEnd: offset={}, limit={}, sort={}, filter={}", offset, limit, sortDesc, filter.isPresent() ? filter.get().toString() : "absent");

      List<SortDTO> recs = filter.isPresent() && filter.get().isNeedFilter() ? new ArrayList<>(O) : new ArrayList<>(R);
      
      Collections.sort(recs, new SortComparator(sortOrders));

      recs = recs.subList(offset, offset + limit);

      return recs.stream();

   }

   @Override
   protected int sizeInBackEnd(Query<SortDTO, SortFilterDTO> query) {
      Optional<SortFilterDTO> filter = query.getFilter();
      List<QuerySortOrder> sortOrders = query.getSortOrders();

      String sortDesc = formatSortDesc(sortOrders);

      int size = filter.isPresent() && filter.get().isNeedFilter() ? O.size() : R.size();

      log.info("sizeInBackEnd: {}, sort={}, filter={}", size, sortDesc, filter.isPresent() ? filter.get().toString() : "absent");

      return size;
   }

   private String formatSortDesc(List<QuerySortOrder> sortOrders) {
      return sortOrders.stream().map(o -> String.format("%s (%s)", o.getSorted(), o.getDirection().toString().substring(0, 1))).collect(Collectors.joining(",", "[", "]"));
   }

   static {
      R = new ArrayList<>();
      O = new ArrayList<>();

      String a = null, b = null, c = null;

      for (int i = 0, j = 0, k = 0, m = 0; i < COUNT; i++) {
         if (j < 10) {
            a = "A";
            j++;
         } else if (j < 20) {
            a = "B";
            j++;
         } else if (j < 30) {
            a = "C";
            j++;
         } else {
            a = "X";
            j = 0;
         }
         if (k < 5) {
            b = "A";
            k++;
         } else if (k < 10) {
            b = "B";
            k++;
         } else if (k < 15) {
            b = "C";
            k++;
         } else {
            b = "X";
            k = 0;
         }
         if (m < 1) {
            c = "A";
            m++;
         } else if (m < 2) {
            c = "B";
            m++;
         } else if (m < 3) {
            c = "C";
            m++;
         } else {
            c = "X";
            m = 0;
         }

         SortDTO rec = new SortDTO(i + 1, a, b, c);
         R.add(rec);

         if (i < COUNT / 2) {
            O.add(rec);
         }
      }
   }
}
