package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import java.util.List;

public class AllClassifiers {

    private List<Route> routes;
    private List<Stop> stops;
    private List<FullStop> fullStops;
    private List<RouteWithStops> routesWithStops;
    private List<RouteOnMap> routesOnMap;
    private StopOnMapWrapper stopOnMapWrapper;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(RouteWrapper routeWrapper) {
        this.routes = routeWrapper.routes;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(StopWrapper stopWrapper) {
        this.stops = stopWrapper.stops;
    }

    public List<FullStop> getFullStops() {
        return fullStops;
    }

    public void setFullStops(FullStopWrapper fullStopWrapper) {
        this.fullStops = fullStopWrapper.fullStops;
    }

    public List<RouteWithStops> getRoutesWithStops() {
        return routesWithStops;
    }

    public void setRoutesWithStops(RouteWithStopsWrapper routeWithStopsWrapper) {
        this.routesWithStops = routeWithStopsWrapper.routeWithStops;
    }

    public List<RouteOnMap> getRoutesOnMap() {
        return routesOnMap;
    }

    public void setRoutesOnMap(RouteOnMapWrapper routeOnMapWrapper) {
        this.routesOnMap = routeOnMapWrapper.routesOnMap;
    }

    public StopOnMapWrapper getStopOnMapWrapper() {
        return stopOnMapWrapper;
    }

    public void setStopOnMapWrapper(StopOnMapWrapper stopOnMapWrapper) {
        this.stopOnMapWrapper = stopOnMapWrapper;
    }

}
