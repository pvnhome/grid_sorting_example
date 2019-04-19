package com.example.sortgrid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.router.Route;

/**
 * The main view of the application
 */
@Route("")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@SuppressWarnings("serial")
public class SortgridView extends VerticalLayout {
   private Logger log = LoggerFactory.getLogger(SortgridView.class.getName());

   private SortDataProvider dataProvider;
   private ConfigurableFilterDataProvider<SortDTO, Void, SortFilterDTO> providerWraper;

   private Grid<SortDTO> grid;

   private Column<SortDTO> colC;
   private Column<SortDTO> colId;

   public SortgridView() {
      log.info("SortgridView");

      setSizeFull();

      HorizontalLayout tools = new HorizontalLayout();

      Button btnSort1 = new Button("Sort 1 [c(A),id(A)]", event -> {
         log.info("button: sort 1");
         grid.sort(GridSortOrder.asc(colC).thenAsc(colId).build());
      });
      tools.add(btnSort1);

      Button btnSort2 = new Button("Sort 2 [c(A),id(D)]", event -> {
         log.info("button: sort 2");
         grid.sort(GridSortOrder.asc(colC).thenDesc(colId).build());
      });
      tools.add(btnSort2);

      Button btnFilterOn = new Button("Filter On", event -> {
         log.info("button: filter on");
         providerWraper.setFilter(new SortFilterDTO(true));
      });
      tools.add(btnFilterOn);

      Button btnFilterOff = new Button("Filter Off", event -> {
         log.info("button: filter off");
         providerWraper.setFilter(new SortFilterDTO(false));
      });
      tools.add(btnFilterOff);

      add(tools);

      grid = new Grid<>();
      colId = grid.addColumn(r -> r.getId().toString()).setKey("id").setHeader("ID").setSortable(true).setWidth("80px");
      grid.addColumn(SortDTO::getA).setKey("a").setHeader("A").setSortable(true).setWidth("80px");
      grid.addColumn(SortDTO::getB).setKey("b").setHeader("B").setSortable(true).setWidth("80px");
      colC = grid.addColumn(SortDTO::getC).setKey("c").setHeader("C").setSortable(true).setWidth("80px");
      grid.setMultiSort(true);

      dataProvider = new SortDataProvider();
      providerWraper = dataProvider.withConfigurableFilter();
      grid.setDataProvider(providerWraper);

      grid.setSizeFull();

      add(grid);
      expand(grid);
   }
}