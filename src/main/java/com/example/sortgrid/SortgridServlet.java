package com.example.sortgrid;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns = "/*", name = "SortgridServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = SortgridUI.class, productionMode = false)
public class SortgridServlet extends VaadinServlet { }