package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class RoutesOnMap {

    @ElementList(entry = "route", inline = true)
    public List<RouteOnMap> routesOnMap;

}
