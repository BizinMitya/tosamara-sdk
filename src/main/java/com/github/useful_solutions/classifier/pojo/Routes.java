package com.github.useful_solutions.classifier.pojo;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class Routes {

    @ElementList(entry = "route", inline = true)
    public List<Route> routes;

}
