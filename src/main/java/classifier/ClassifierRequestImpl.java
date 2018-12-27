package classifier;

import classifier.pojo.*;

public class ClassifierRequestImpl implements ClassifierRequest {

    @Override
    public Classifiers getClassifiers() {
        return doClassifierRequest(Classifiers.class, CLASSIFIERS_URL);
    }

    @Override
    public Stops getStops() {
        return doClassifierRequest(Stops.class, STOPS_URL);
    }

    @Override
    public FullStops getFullStops() {
        return doClassifierRequest(FullStops.class, STOPS_FULL_URL);
    }

    @Override
    public Routes getRoutes() {
        return doClassifierRequest(Routes.class, ROUTES_URL);
    }

    @Override
    public RoutesWithStops getRoutesWithStops() {
        return doClassifierRequest(RoutesWithStops.class, ROUTES_AND_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public StopsOnMap getStopsOnMap() {
        return doClassifierRequest(StopsOnMap.class, GEOPORTAL_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public RoutesOnMap getRoutesOnMap() {
        return doClassifierRequest(RoutesOnMap.class, GEOPORTAL_ROUTES_CORRESPONDENCE_URL);
    }

}
