import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.Criterion;
import api.record.pojo.GeoPoint;
import api.record.pojo.TransportType;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.FullStop;
import classifier.pojo.RouteWithStops;
import classifier.pojo.Stop;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class APITest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final Logger LOGGER = Logger.getLogger(APITest.class);

    @Test
    void runAllRandomTests() {
        getFirstArrivalToStopRandomTest();
        findShortestPathRandomTest();
        getRouteArrivalToStopRandomTest();
    }

    @Test
    void runAllFullTests() {
        getFirstArrivalToStopFullTest();
        findShortestPathFullTest();
        getRouteArrivalToStopFullTest();
    }

    @Test
    void getFirstArrivalToStopFullTest() {
        try {
            LOGGER.info("");
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            stops.forEach(stop -> {
                LOGGER.info(stop.title);
                API_REQUEST.getFirstArrivalToStop(stop.ksId, null);
            });
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getFirstArrivalToStopRandomTest() {
        try {
            Random random = new Random();
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            Stop stop = stops.get(random.nextInt(stops.size()));
            API_REQUEST.getFirstArrivalToStop(stop.ksId, null);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    /**
     * Матричный тест.
     */
    @Test
    void findShortestPathFullTest() {
        try {
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().stops;
            for (FullStop fullStop1 : fullStops) {
                for (FullStop fullStop2 : fullStops) {
                    LOGGER.info(fullStop1.title + " " + fullStop2.title);
                    GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
                    GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
                    API_REQUEST.findShortestPath(geoPoint1, geoPoint2, Criterion.time, TransportType.bus);
                }
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void findShortestPathRandomTest() {
        try {
            Random random = new Random();
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().stops;
            FullStop fullStop1 = fullStops.get(random.nextInt(fullStops.size()));
            FullStop fullStop2 = fullStops.get(random.nextInt(fullStops.size()));
            GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
            GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
            API_REQUEST.findShortestPath(geoPoint1, geoPoint2, Criterion.time, TransportType.bus);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    /**
     * Матричный тест.
     */
    @Test
    void getRouteArrivalToStopFullTest() {
        try {
            List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops().routeWithStops;
            for (RouteWithStops routeWithStops : routesWithStops) {
                List<RouteWithStops.Stop> stops = routeWithStops.stops;
                for (RouteWithStops.Stop stop : stops) {
                    LOGGER.info(stop.title + " " + routeWithStops.number);
                    API_REQUEST.getRouteArrivalToStop(stop.ksId, routeWithStops.krId);
                }
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRouteArrivalToStopRandomTest() {
        try {
            Random random = new Random();
            List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops().routeWithStops;
            RouteWithStops routeWithStops = routesWithStops.get(random.nextInt(routesWithStops.size()));
            RouteWithStops.Stop stop = routeWithStops.stops.get(random.nextInt(routeWithStops.stops.size()));
            API_REQUEST.getRouteArrivalToStop(stop.ksId, routeWithStops.krId);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

}
