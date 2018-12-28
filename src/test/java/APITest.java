import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.GeoPoint;
import api.record.pojo.Transport;
import api.record.request.FindShortestPathRequest;
import api.record.response.GetFirstArrivalToStopResponse;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.FullStop;
import classifier.pojo.Route;
import classifier.pojo.RouteWithStops;
import classifier.pojo.Stop;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static api.record.request.FindShortestPathRequest.Criterion.time;
import static api.record.request.FindShortestPathRequest.TransportType.bus;

class APITest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final Logger LOGGER = Logger.getLogger(APITest.class);
    private static final Random RANDOM = new Random();

    @Test
    void runAllRandomTests() {
        getFirstArrivalToStopRandomTest();
        findShortestPathRandomTest();
        getRouteArrivalToStopRandomTest();
        getRouteScheduleRandomTest();
        getTransportPositionRandomTest();
        getSurroundingTransportsRandomTest();
    }

    @Test
    void runAllFullTests() {
        getFirstArrivalToStopFullTest();
        findShortestPathFullTest();
        getRouteArrivalToStopFullTest();
        getRouteScheduleAllTest();
        getTransportPositionFullTest();
        getSurroundingTransportsFullTest();
    }

    @Test
    void getFirstArrivalToStopFullTest() {
        try {
            LOGGER.info("");
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            stops.forEach(stop -> {
                LOGGER.info(stop.title);
                API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
            });
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getFirstArrivalToStopRandomTest() {
        try {
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            Stop stop = stops.get(RANDOM.nextInt(stops.size()));
            API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void findShortestPathFullTest() {
        try {
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().fullStops;
            for (FullStop fullStop1 : fullStops) {
                for (FullStop fullStop2 : fullStops) {
                    LOGGER.info(fullStop1.title + " " + fullStop2.title);
                    GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
                    GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
                    API_REQUEST.findShortestPath(geoPoint1, geoPoint2, time, FindShortestPathRequest.TransportType.bus);
                }
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void findShortestPathRandomTest() {
        try {
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().fullStops;
            FullStop fullStop1 = fullStops.get(RANDOM.nextInt(fullStops.size()));
            FullStop fullStop2 = fullStops.get(RANDOM.nextInt(fullStops.size()));
            GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
            GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
            API_REQUEST.findShortestPath(geoPoint1, geoPoint2, time, bus);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

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
            List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops().routeWithStops;
            RouteWithStops routeWithStops = routesWithStops.get(RANDOM.nextInt(routesWithStops.size()));
            RouteWithStops.Stop stop = routeWithStops.stops.get(RANDOM.nextInt(routeWithStops.stops.size()));
            API_REQUEST.getRouteArrivalToStop(stop.ksId, routeWithStops.krId);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRouteScheduleAllTest() {
        try {
            List<Route> routes = CLASSIFIER_REQUEST.getRoutes().routes;
            String day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            routes.forEach(route -> API_REQUEST.getRouteSchedule(route.krId, day));
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getRouteScheduleRandomTest() {
        try {
            List<Route> routes = CLASSIFIER_REQUEST.getRoutes().routes;
            Route route = routes.get(RANDOM.nextInt(routes.size()));
            String day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            API_REQUEST.getRouteSchedule(route.krId, day);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getTransportPositionRandomTest() {
        try {
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            Stop stop = stops.get(RANDOM.nextInt(stops.size()));
            GetFirstArrivalToStopResponse response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
            while (response.transports.isEmpty()) {
                stop = stops.get(RANDOM.nextInt(stops.size()));
                response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
            }
            Transport transport = response.transports.get(RANDOM.nextInt(response.transports.size()));
            API_REQUEST.getTransportPosition(transport.hullNo);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getTransportPositionFullTest() {
        try {
            List<Stop> stops = CLASSIFIER_REQUEST.getStops().stops;
            for (Stop stop : stops) {
                GetFirstArrivalToStopResponse response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
                for (Transport transport : response.transports) {
                    API_REQUEST.getTransportPosition(transport.hullNo);
                }
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getSurroundingTransportsRandomTest() {
        try {

            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().fullStops;
            FullStop fullStop = fullStops.get(RANDOM.nextInt(fullStops.size()));
            GeoPoint geoPoint = new GeoPoint(fullStop.latitude, fullStop.longitude);
            API_REQUEST.getSurroundingTransports(geoPoint, 10_000D, Integer.MAX_VALUE);
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

    @Test
    void getSurroundingTransportsFullTest() {
        try {
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops().fullStops;
            for (FullStop fullStop : fullStops) {
                GeoPoint geoPoint = new GeoPoint(fullStop.latitude, fullStop.longitude);
                API_REQUEST.getSurroundingTransports(geoPoint, 10_000D, Integer.MAX_VALUE);
            }
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

}
