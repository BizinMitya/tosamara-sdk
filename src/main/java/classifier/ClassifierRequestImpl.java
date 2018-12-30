package classifier;

import classifier.pojo.*;

public class ClassifierRequestImpl implements ClassifierRequest {

    @Override
    public Classifiers getClassifiers() throws Exception {
        return doClassifierRequest(Classifiers.class, CLASSIFIERS_URL);
    }

    @Override
    public Stops getStops() throws Exception {
        return doClassifierRequest(Stops.class, STOPS_URL);
    }

    @Override
    public FullStops getFullStops() throws Exception {
        return doClassifierRequest(FullStops.class, STOPS_FULL_URL);
    }

    @Override
    public Routes getRoutes() throws Exception {
        return doClassifierRequest(Routes.class, ROUTES_URL);
    }

    @Override
    public RoutesWithStops getRoutesWithStops() throws Exception {
        return doClassifierRequest(RoutesWithStops.class, ROUTES_AND_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public StopsOnMap getStopsOnMap() throws Exception {
        return doClassifierRequest(StopsOnMap.class, GEOPORTAL_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public RoutesOnMap getRoutesOnMap() throws Exception {
        return doClassifierRequest(RoutesOnMap.class, GEOPORTAL_ROUTES_CORRESPONDENCE_URL);
    }

}
