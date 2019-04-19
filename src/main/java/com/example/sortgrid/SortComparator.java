package com.example.sortgrid;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import com.vaadin.flow.data.provider.QuerySortOrder;
import com.vaadin.flow.data.provider.SortDirection;

/**
 * <p><b>Created:</b> 16.04.2019 23:23:03</p>
 * @author victor
 */
public class SortComparator implements Comparator<SortDTO> {
   private final List<QuerySortOrder> orders;

   public SortComparator(List<QuerySortOrder> orders) {
      this.orders = orders;
   }

   @Override
   public int compare(SortDTO arg0, SortDTO arg1) {
      for (QuerySortOrder o : orders) {
         if ("id".equals(o.getSorted())) {
            int result = doCompare(arg0::getId, arg1::getId, o.getDirection());
            if (result != 0) {
               return result;
            }
         } else if ("a".equals(o.getSorted())) {
            int result = doCompareStr(arg0::getA, arg1::getA, o.getDirection());
            if (result != 0) {
               return result;
            }
         } else if ("b".equals(o.getSorted())) {
            int result = doCompareStr(arg0::getB, arg1::getB, o.getDirection());
            if (result != 0) {
               return result;
            }
         } else if ("c".equals(o.getSorted())) {
            int result = doCompareStr(arg0::getC, arg1::getC, o.getDirection());
            if (result != 0) {
               return result;
            }
         }
      }
      return 0;
   }

   private int doCompare(Supplier<Integer> o1, Supplier<Integer> o2, SortDirection direction) {
      if (o1.get() == null && o2.get() == null) {
         return 0;
      } else if (o1.get() != null && o2.get() == null) {
         return direction == SortDirection.ASCENDING ? -1 : 1;
      } else if (o1.get() == null && o2.get() != null) {
         return direction == SortDirection.ASCENDING ? -1 : 1;
      } else {
         return direction == SortDirection.ASCENDING ? o1.get().compareTo(o2.get()) : o2.get().compareTo(o1.get());
      }
   }

   private int doCompareStr(Supplier<String> o1, Supplier<String> o2, SortDirection direction) {
      if (o1.get() == null && o2.get() == null) {
         return 0;
      } else if (o1.get() != null && o2.get() == null) {
         return direction == SortDirection.ASCENDING ? -1 : 1;
      } else if (o1.get() == null && o2.get() != null) {
         return direction == SortDirection.ASCENDING ? -1 : 1;
      } else {
         return direction == SortDirection.ASCENDING ? o1.get().compareTo(o2.get()) : o2.get().compareTo(o1.get());
      }
   }
}
