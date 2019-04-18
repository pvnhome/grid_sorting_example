package com.example.sortgrid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.Route;

/**
 * The main view of the application
 */
@Route("")
@BodySize(height = "100vh", width = "100vw")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@SuppressWarnings("serial")
public class SortgridView extends VerticalLayout {
   Logger log = LoggerFactory.getLogger(SortgridView.class.getName());

   public SortgridView() {
      log.info("SortgridView");

      setClassName("app-view");

      Label hello = new Label("Hello Gradle app!");
      add(hello);

      Button button = new Button("Click me", event -> {
         log.info("click");
         hello.setText("Clicked!");
         hello.setClassName("clicked");
      });
      add(button);
   }
}
