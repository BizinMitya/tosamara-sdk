package com.github.useful_solutions.tosamara_sdk.calculate;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequest;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequestImpl;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.FullStop;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.RouteWithStops;

import java.util.List;

public class DistanceUtil {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final double EARTH_RADIUS = 6_371_000;// in m

    private DistanceUtil() {
    }

    /**
     * Метод подсчета расстояния между двумя остановками выбранного маршрута.
     *
     * @param krId     классификаторный номер машрута.
     * @param fromKsId остановка отправления.
     * @param toKsId   остановка прибытия.
     * @return расстояния между двумя остановками маршрута.
     * @throws Exception выбрасывается в случае некорректных параметров, либо в случае ошибок получения информации через API tosamara.ru.
     */
    public static double distanceBetweenStops(int krId, int fromKsId, int toKsId) throws Exception {
        List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
        List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops();
        RouteWithStops routeWithStops = routesWithStops.stream()
                .filter(route -> route.krId == krId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect id of route (%d)", krId)));
        long countMatchedStops = routeWithStops.stops.stream()
                .filter(stop -> stop.ksId == fromKsId || stop.ksId == toKsId)
                .count();
        if (countMatchedStops != 2) {
            throw new IllegalArgumentException(String.format("Incorrect ids of stops (%d or %d)", fromKsId, toKsId));
        }
        GeoPoint fromGeoPoint = fullStops.stream()
                .filter(fullStop -> fullStop.ksId == fromKsId)
                .map(fullStop -> new GeoPoint(fullStop.latitude, fullStop.longitude))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect id of stop (%d)", fromKsId)));
        GeoPoint toGeoPoint = fullStops.stream()
                .filter(fullStop -> fullStop.ksId == toKsId)
                .map(fullStop -> new GeoPoint(fullStop.latitude, fullStop.longitude))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect id of stop (%d)", toKsId)));
        List<GeoPoint> pointsBetweenStops = getPointsBetweenStops(routeWithStops.geometry, fromGeoPoint, toGeoPoint);
        return totalDistance(pointsBetweenStops);
    }

    /**
     * Метод расчета расстояния по прямой между двумя точками.
     *
     * @param lat1 широта первой точки.
     * @param lon1 долгота первой точки.
     * @param lat2 широта второй точки.
     * @param lon2 долгота второй точки.
     * @return расстояние по прямой между точками.
     */
    public static double distanceBetweenPoints(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);
        return EARTH_RADIUS * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }

    /**
     * Метод расчета расстояния по прямой между двумя точками.
     *
     * @param geoPoint1 первая точка.
     * @param geoPoint2 вторая точка.
     * @return расстояние по прямой между точками.
     * @see #distanceBetweenPoints
     */
    public static double distanceBetweenPoints(GeoPoint geoPoint1, GeoPoint geoPoint2) {
        return distanceBetweenPoints(geoPoint1.latitude, geoPoint1.longitude, geoPoint2.latitude, geoPoint2.longitude);
    }

    /**
     * Метод подсчета суммарного расстояния маршрута, заданного в виде списка точек (геометрия маршрута).
     *
     * @param points геометрия маршрута.
     * @return расстояние маршрута.
     */
    public static double totalDistance(List<GeoPoint> points) {
        double sum = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            GeoPoint from = points.get(i);
            GeoPoint to = points.get(i + 1);
            sum += distanceBetweenPoints(from.latitude, from.longitude, to.latitude, to.longitude);
        }
        return sum;
    }

    /**
     * Метод получения ближайшей точки из списка к переданной точке.
     *
     * @param geoPoint точка, к которой нужно найти ближайшую из списка.
     * @param points   список точек (геометрия маршрута, задан порядок).
     * @return индекс ближайшей точки из списка.
     */
    private static int getClosestPoint(GeoPoint geoPoint, List<GeoPoint> points) {
        double minDistance = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < points.size(); i++) {
            double distance = distanceBetweenPoints(geoPoint, points.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                index = i;
            }
        }
        return index;
    }

    /**
     * Метод получения точек маршрута между двумя остановками, включая сами остановки.
     *
     * @param points точки маршрута.
     * @param from   координаты остановки отправления.
     * @param to     координаты остановки прибытия.
     * @return точки маршрута между двумя остановками.
     */
    private static List<GeoPoint> getPointsBetweenStops(List<GeoPoint> points, GeoPoint from, GeoPoint to) {
        int closestFromIndex = getClosestPoint(from, points);
        int closestToIndex = getClosestPoint(to, points);
        // точки маршрута, не включая ближайшие
        List<GeoPoint> result = points.subList(closestFromIndex + 1, closestToIndex);
        // обрамляем точки маршрута по краям точками остановок отправления и прибытия
        result.add(0, from);
        result.add(to);
        // если ближайшие точки находятся внутри, то добавляем их
        double distance = totalDistance(result);
        result.add(1, points.get(closestFromIndex));
        if (totalDistance(result) > distance) {
            result.remove(1);
        }
        result.add(result.size() - 1, points.get(closestToIndex));
        if (totalDistance(result) > distance) {
            result.remove(result.size() - 1);
        }
        return result;
    }

}