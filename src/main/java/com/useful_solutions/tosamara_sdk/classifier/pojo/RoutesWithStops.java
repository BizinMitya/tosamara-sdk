package com.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "routes")
public class RoutesWithStops {

    @ElementList(entry = "route", inline = true)
    public List<RouteWithStops> routeWithStops;

}
