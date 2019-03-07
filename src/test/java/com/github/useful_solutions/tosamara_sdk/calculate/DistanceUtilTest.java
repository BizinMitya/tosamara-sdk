package com.github.useful_solutions.tosamara_sdk.calculate;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequest;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequestImpl;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.FullStop;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.Route;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.RouteWithStops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class DistanceUtilTest {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static List<FullStop> fullStops;
    private static List<RouteWithStops> routesWithStops;
    private static List<Route> routes;
    private static final double DELTA = 250;// in m

    @BeforeAll
    static void initializeClassifiers() {
        try {
            fullStops = CLASSIFIER_REQUEST.getFullStops();
            routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
            routes = CLASSIFIER_REQUEST.getRoutes();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void distanceUtilTest() {
        try {
            int krId = 109;
            calculateDistancesOnRoute(krId);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private GeoPoint getPointOfStop(List<FullStop> fullStops, int ksId) throws Exception {
        return fullStops.stream()
                .filter(fullStop -> fullStop.ksId == ksId)
                .map(fullStop -> new GeoPoint(fullStop.latitude, fullStop.longitude))
                .findAny()
                .orElseThrow(() -> new Exception(String.format("Not found ksId = %d", ksId)));
    }

    private void calculateDistancesOnRoute(int krId) throws Exception {
        RouteWithStops routeWithStops = routesWithStops.stream()
                .filter(route -> route.krId == krId)
                .findAny()
                .orElseThrow(() -> new Exception(String.format("Not found krId = %d", krId)));
        for (int i = 0; i < routeWithStops.stops.size() - 1; i++) {
            RouteWithStops.Stop fromStop = routeWithStops.stops.get(i);
            RouteWithStops.Stop toStop = routeWithStops.stops.get(i + 1);
            GeoPoint from = getPointOfStop(fullStops, fromStop.ksId);
            GeoPoint to = getPointOfStop(fullStops, toStop.ksId);
            System.out.println("Расстояние между " + fromStop.title + " и " + toStop.title + ": " + DistanceUtil.distanceBetweenStops(routeWithStops.geometry, from, to));
        }
    }

    @Test
    void distanceUtilAllTest() {
        try {
            for (Route route : routes) {
                System.out.println("Маршрут: " + route.number + ", в сторону " + route.direction);
                calculateDistancesOnRoute(route.krId);
                System.out.println();
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void checkDeviationTest() {
        try {
            int krId = 109;
            Assertions.assertEquals(getStopsDistance(krId), getGeometryDistance(krId), DELTA);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Test
    void checkDeviationAllTest() {
        try {
            for (Route route : routes) {
                int krId = route.krId;
                Assertions.assertEquals(getStopsDistance(krId), getGeometryDistance(krId), DELTA);
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private double getStopsDistance(int krId) throws Exception {
        RouteWithStops routeWithStops = routesWithStops.stream()
                .filter(route -> route.krId == krId)
                .findAny()
                .orElseThrow(() -> new Exception(String.format("Not found krId = %d", krId)));
        double sum = 0;
        for (int i = 0; i < routeWithStops.stops.size() - 1; i++) {
            RouteWithStops.Stop fromStop = routeWithStops.stops.get(i);
            RouteWithStops.Stop toStop = routeWithStops.stops.get(i + 1);
            GeoPoint from = getPointOfStop(fullStops, fromStop.ksId);
            GeoPoint to = getPointOfStop(fullStops, toStop.ksId);
            sum += DistanceUtil.distanceBetweenStops(routeWithStops.geometry, from, to);
        }
        return sum;
    }

    private double getGeometryDistance(int krId) throws Exception {
        RouteWithStops routeWithStops = routesWithStops.stream()
                .filter(route -> route.krId == krId)
                .findAny()
                .orElseThrow(() -> new Exception(String.format("Not found krId = %d", krId)));
        double sum = 0;
        for (int i = 0; i < routeWithStops.geometry.size() - 1; i++) {
            GeoPoint geoPoint1 = routeWithStops.geometry.get(i);
            GeoPoint geoPoint2 = routeWithStops.geometry.get(i + 1);
            sum += DistanceUtil.distanceBetweenPoints(geoPoint1, geoPoint2);
        }
        return sum;
    }

}
