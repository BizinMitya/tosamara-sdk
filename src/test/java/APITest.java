import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.ArrivalTransport;
import api.record.pojo.GeoPoint;
import api.record.request.FindShortestPathRequest;
import api.record.response.GetFirstArrivalToStopResponse;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.FullStop;
import classifier.pojo.Route;
import classifier.pojo.RouteWithStops;
import classifier.pojo.Stop;
import exception.APIResponseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static api.record.request.FindShortestPathRequest.Criterion.time;
import static api.record.request.FindShortestPathRequest.TransportType.bus;

class APITest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final Random RANDOM = new Random();
    private static List<Stop> stops;
    private static List<FullStop> fullStops;
    private static List<RouteWithStops> routesWithStops;
    private static List<Route> routes;

    @BeforeAll
    static void initializeClassifiers() {
        try {
            stops = CLASSIFIER_REQUEST.getStops().stops;
            fullStops = CLASSIFIER_REQUEST.getFullStops().fullStops;
            routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops().routeWithStops;
            routes = CLASSIFIER_REQUEST.getRoutes().routes;
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void runAllRandomTests() {
        getFirstArrivalToStopRandomTest();
        findShortestPathRandomTest();
        getRouteArrivalToStopRandomTest();
        getRouteScheduleRandomTest();
        getTransportPositionRandomTest();
        getSurroundingTransportsRandomTest();
        getTransportsOnRouteRandomTest();
    }

    @Test
    void runAllFullTests() {
        getFirstArrivalToStopFullTest();
        findShortestPathFullTest();
        getRouteArrivalToStopFullTest();
        getRouteScheduleAllTest();
        getTransportPositionFullTest();
        getSurroundingTransportsFullTest();
        getTransportsOnRouteFullTest();
    }

    @Test
    void getFirstArrivalToStopFullTest() {
        try {
            stops.forEach(stop -> {
                try {
                    API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
                } catch (APIResponseException | IOException e) {
                    Assertions.fail(e);
                }
            });
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getFirstArrivalToStopRandomTest() {
        try {
            Stop stop = stops.get(RANDOM.nextInt(stops.size()));
            API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void findShortestPathFullTest() {
        try {
            for (FullStop fullStop1 : fullStops) {
                for (FullStop fullStop2 : fullStops) {
                    GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
                    GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
                    API_REQUEST.findShortestPath(geoPoint1, geoPoint2, time, FindShortestPathRequest.TransportType.bus);
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void findShortestPathRandomTest() {
        try {
            FullStop fullStop1 = fullStops.get(RANDOM.nextInt(fullStops.size()));
            FullStop fullStop2 = fullStops.get(RANDOM.nextInt(fullStops.size()));
            GeoPoint geoPoint1 = new GeoPoint(fullStop1.latitude, fullStop1.longitude);
            GeoPoint geoPoint2 = new GeoPoint(fullStop2.latitude, fullStop2.longitude);
            API_REQUEST.findShortestPath(geoPoint1, geoPoint2, time, bus);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRouteArrivalToStopFullTest() {
        try {
            for (RouteWithStops routeWithStops : routesWithStops) {
                List<RouteWithStops.Stop> stops = routeWithStops.stops;
                for (RouteWithStops.Stop stop : stops) {
                    API_REQUEST.getRouteArrivalToStop(stop.ksId, routeWithStops.krId);
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRouteArrivalToStopRandomTest() {
        try {
            RouteWithStops routeWithStops = routesWithStops.get(RANDOM.nextInt(routesWithStops.size()));
            RouteWithStops.Stop stop = routeWithStops.stops.get(RANDOM.nextInt(routeWithStops.stops.size()));
            API_REQUEST.getRouteArrivalToStop(stop.ksId, routeWithStops.krId);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRouteScheduleAllTest() {
        try {
            String day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            routes.forEach(route -> {
                try {
                    API_REQUEST.getRouteSchedule(route.krId, day);
                } catch (APIResponseException | IOException e) {
                    Assertions.fail(e);
                }
            });
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getRouteScheduleRandomTest() {
        try {
            Route route = routes.get(RANDOM.nextInt(routes.size()));
            String day = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            API_REQUEST.getRouteSchedule(route.krId, day);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getTransportPositionRandomTest() {
        try {
            Stop stop = stops.get(RANDOM.nextInt(stops.size()));
            GetFirstArrivalToStopResponse response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
            while (response.arrivalTransports.isEmpty()) {
                stop = stops.get(RANDOM.nextInt(stops.size()));
                response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
            }
            ArrivalTransport arrivalTransport = response.arrivalTransports.get(RANDOM.nextInt(response.arrivalTransports.size()));
            API_REQUEST.getTransportPosition(arrivalTransport.hullNo);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getTransportPositionFullTest() {
        try {
            for (Stop stop : stops) {
                GetFirstArrivalToStopResponse response = API_REQUEST.getFirstArrivalToStop(stop.ksId, Integer.MAX_VALUE);
                for (ArrivalTransport arrivalTransport : response.arrivalTransports) {
                    API_REQUEST.getTransportPosition(arrivalTransport.hullNo);
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getSurroundingTransportsRandomTest() {
        try {
            FullStop fullStop = fullStops.get(RANDOM.nextInt(fullStops.size()));
            GeoPoint geoPoint = new GeoPoint(fullStop.latitude, fullStop.longitude);
            API_REQUEST.getSurroundingTransports(geoPoint, 10_000D, Integer.MAX_VALUE);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getSurroundingTransportsFullTest() {
        try {
            for (FullStop fullStop : fullStops) {
                GeoPoint geoPoint = new GeoPoint(fullStop.latitude, fullStop.longitude);
                API_REQUEST.getSurroundingTransports(geoPoint, 1_000D, Integer.MAX_VALUE);
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getTransportsOnRouteRandomTest() {
        try {
            Route route = routes.get(RANDOM.nextInt(routes.size()));
            API_REQUEST.getTransportsOnRoute(route.krId, Integer.MAX_VALUE);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getTransportsOnRouteFullTest() {
        try {
            for (Route route : routes) {
                API_REQUEST.getTransportsOnRoute(route.krId, Integer.MAX_VALUE);
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
