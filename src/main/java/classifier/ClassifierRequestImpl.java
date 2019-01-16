package classifier;

import classifier.pojo.*;

import java.util.List;

public class ClassifierRequestImpl implements ClassifierRequest {

    @Override
    public List<Classifier> getClassifiers() throws Exception {
        Classifiers classifiers = doClassifierRequest(Classifiers.class, CLASSIFIERS_URL);
        return classifiers.files;
    }

    @Override
    public List<Stop> getStops() throws Exception {
        Stops stops = doClassifierRequest(Stops.class, STOPS_URL);
        return stops.stops;
    }

    @Override
    public List<FullStop> getFullStops() throws Exception {
        FullStops fullStops = doClassifierRequest(FullStops.class, STOPS_FULL_URL);
        return fullStops.fullStops;
    }

    @Override
    public List<Route> getRoutes() throws Exception {
        Routes routes = doClassifierRequest(Routes.class, ROUTES_URL);
        return routes.routes;
    }

    @Override
    public List<RouteWithStops> getRoutesWithStops() throws Exception {
        RoutesWithStops routesWithStops = doClassifierRequest(RoutesWithStops.class, ROUTES_AND_STOPS_CORRESPONDENCE_URL);
        return routesWithStops.routeWithStops;
    }

    @Override
    public StopsOnMap getStopsOnMap() throws Exception {
        return doClassifierRequest(StopsOnMap.class, GEOPORTAL_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public List<RouteOnMap> getRoutesOnMap() throws Exception {
        RoutesOnMap routesOnMap = doClassifierRequest(RoutesOnMap.class, GEOPORTAL_ROUTES_CORRESPONDENCE_URL);
        return routesOnMap.routesOnMap;
    }

}
