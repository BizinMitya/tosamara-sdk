package com.github.useful_solutions.tosamara_sdk.classifier;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.*;
import org.junit.jupiter.api.Assertions;

import java.util.List;

class ClassifierAssert {

    static void assertClassifiers(List<Classifier> classifiers) {
        Assertions.assertNotNull(classifiers);
        Assertions.assertFalse(classifiers.isEmpty());
        for (Classifier classifier : classifiers) {
            Assertions.assertNotNull(classifier);
            Assertions.assertNotNull(classifier.modified);
            Assertions.assertNotNull(classifier.name);
        }
    }

    static void assertAllClassifiers(AllClassifiers allClassifiers) {
        Assertions.assertNotNull(allClassifiers);
        assertStops(allClassifiers.getStops());
        assertFullStops(allClassifiers.getFullStops());
        assertRoutes(allClassifiers.getRoutes());
        assertRoutesWithStops(allClassifiers.getRoutesWithStops());
        assertStopsOnMap(allClassifiers.getStopOnMapWrapper());
        assertRoutesOnMap(allClassifiers.getRoutesOnMap());
    }

    static void assertStops(List<Stop> stops) {
        Assertions.assertNotNull(stops);
        Assertions.assertFalse(stops.isEmpty());
        for (Stop stop : stops) {
            Assertions.assertNotNull(stop);
            Assertions.assertNotNull(stop.ksId);
            Assertions.assertNotNull(stop.title);
            //Assertions.assertNotNull(stop.adjacentStreet);
            //Assertions.assertNotNull(stop.adjacentStreetEn);
            //Assertions.assertNotNull(stop.adjacentStreetEs);
            //Assertions.assertNotNull(stop.direction);
            //Assertions.assertNotNull(stop.directionEn);
            //Assertions.assertNotNull(stop.directionEs);
            //Assertions.assertNotNull(stop.external);
            //Assertions.assertNotNull(stop.titleEn);
            //Assertions.assertNotNull(stop.titleEs);
        }
    }

    static void assertFullStops(List<FullStop> fullStops) {
        Assertions.assertNotNull(fullStops);
        Assertions.assertFalse(fullStops.isEmpty());
        for (FullStop fullStop : fullStops) {
            Assertions.assertNotNull(fullStop);
            Assertions.assertNotNull(fullStop.latitude);
            Assertions.assertNotNull(fullStop.longitude);
            Assertions.assertNotNull(fullStop.title);
            Assertions.assertNotNull(fullStop.busesCommercial);
            Assertions.assertNotNull(fullStop.busesIntercity);
            Assertions.assertNotNull(fullStop.busesMunicipal);
            Assertions.assertNotNull(fullStop.busesPrigorod);
            Assertions.assertNotNull(fullStop.busesSeason);
            Assertions.assertNotNull(fullStop.busesSpecial);
            Assertions.assertNotNull(fullStop.electricTrains);
            Assertions.assertNotNull(fullStop.trolleybuses);
            Assertions.assertNotNull(fullStop.ksId);
            Assertions.assertNotNull(fullStop.title);
            //Assertions.assertNotNull(fullStop.titleEs);
            //Assertions.assertNotNull(fullStop.titleEn);
            Assertions.assertNotNull(fullStop.infotabloExists);
            //Assertions.assertNotNull(fullStop.direction);
            //Assertions.assertNotNull(fullStop.directionEn);
            //Assertions.assertNotNull(fullStop.directionEs);
            Assertions.assertNotNull(fullStop.metros);
            Assertions.assertNotNull(fullStop.riverTransports);
            //Assertions.assertNotNull(fullStop.adjacentStreet);
            //Assertions.assertNotNull(fullStop.adjacentStreetEn);
            //Assertions.assertNotNull(fullStop.adjacentStreetEs);
            //Assertions.assertNotNull(fullStop.cluster);
            Assertions.assertNotNull(fullStop.trams);
            //Assertions.assertNotNull(fullStop.angle);
        }
    }

    static void assertRoutes(List<Route> routes) {
        Assertions.assertNotNull(routes);
        Assertions.assertFalse(routes.isEmpty());
        for (Route route : routes) {
            Assertions.assertNotNull(route);
            Assertions.assertNotNull(route.krId);
            Assertions.assertNotNull(route.affiliation);
            Assertions.assertNotNull(route.affiliationID);
            Assertions.assertNotNull(route.direction);
            Assertions.assertNotNull(route.directionEn);
            //Assertions.assertNotNull(route.directionEs);
            Assertions.assertNotNull(route.number);
            Assertions.assertNotNull(route.realtimeForecast);
            Assertions.assertNotNull(route.transportType);
            Assertions.assertNotNull(route.transportTypeID);
        }
    }

    static void assertRoutesWithStops(List<RouteWithStops> routesWithStops) {
        Assertions.assertNotNull(routesWithStops);
        Assertions.assertFalse(routesWithStops.isEmpty());
        for (RouteWithStops routeWithStops : routesWithStops) {
            Assertions.assertNotNull(routeWithStops);
            Assertions.assertNotNull(routeWithStops.stops);
            ClassifierAssert.assertStopsFromRouteWithStops(routeWithStops.stops);
            Assertions.assertNotNull(routeWithStops.krId);
            Assertions.assertNotNull(routeWithStops.direction);
            Assertions.assertNotNull(routeWithStops.number);
            Assertions.assertNotNull(routeWithStops.performing);
            Assertions.assertNotNull(routeWithStops.realtimeForecast);
            Assertions.assertNotNull(routeWithStops.transportType);
            Assertions.assertNotNull(routeWithStops.geometry);
            assertGeoPoints(routeWithStops.geometry);
        }
    }

    private static void assertGeoPoints(List<GeoPoint> geoPoints) {
        Assertions.assertNotNull(geoPoints);
        Assertions.assertFalse(geoPoints.isEmpty());
        for (GeoPoint geoPoint : geoPoints) {
            Assertions.assertNotNull(geoPoint);
            Assertions.assertNotNull(geoPoint.latitude);
            Assertions.assertNotNull(geoPoint.longitude);
        }
    }

    private static void assertStopsFromRouteWithStops(List<RouteWithStops.Stop> stops) {
        Assertions.assertNotNull(stops);
        Assertions.assertFalse(stops.isEmpty());
        for (RouteWithStops.Stop stop : stops) {
            Assertions.assertNotNull(stop);
            Assertions.assertNotNull(stop.ksId);
            //Assertions.assertNotNull(stop.adjacentStreet);
            //Assertions.assertNotNull(stop.direction);
            Assertions.assertNotNull(stop.scheduleTime);
            Assertions.assertNotNull(stop.title);
        }
    }

    static void assertStopsOnMap(StopOnMapWrapper stopOnMapWrapper) {
        Assertions.assertNotNull(stopOnMapWrapper);
        Assertions.assertNotNull(stopOnMapWrapper.layerName);
        List<StopOnMap> stopOnMaps = stopOnMapWrapper.stopsOnMap;
        Assertions.assertNotNull(stopOnMaps);
        Assertions.assertFalse(stopOnMaps.isEmpty());
        for (StopOnMap stopOnMap : stopOnMaps) {
            Assertions.assertNotNull(stopOnMap);
            Assertions.assertNotNull(stopOnMap.ksId);
            Assertions.assertNotNull(stopOnMap.geoportalId);
            Assertions.assertNotNull(stopOnMap.staticDescription);
        }
    }

    static void assertRoutesOnMap(List<RouteOnMap> routesOnMaps) {
        Assertions.assertNotNull(routesOnMaps);
        Assertions.assertFalse(routesOnMaps.isEmpty());
        for (RouteOnMap routeOnMap : routesOnMaps) {
            Assertions.assertNotNull(routeOnMap);
            Assertions.assertNotNull(routeOnMap.geoportalId);
            Assertions.assertNotNull(routeOnMap.krId);
            Assertions.assertNotNull(routeOnMap.layerName);
        }
    }

}
