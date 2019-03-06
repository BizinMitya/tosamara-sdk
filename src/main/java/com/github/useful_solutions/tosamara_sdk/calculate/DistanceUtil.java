package com.github.useful_solutions.tosamara_sdk.calculate;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

import java.util.ArrayList;
import java.util.List;

public class DistanceUtil {

    private static final double EARTH_RADIUS = 6_371_000;// in m

    private DistanceUtil() {
    }

    /**
     * Метод расчета расстояния между двумя остановками выбранного маршрута.
     *
     * @param geometry     геометрия выбранного маршрута ({@link com.github.useful_solutions.tosamara_sdk.classifier.pojo.RouteWithStops#geometry}).
     * @param fromGeoPoint координаты остановки отправления.
     * @param toGeoPoint   координаты остановки прибытия.
     * @return расстояния между двумя остановками маршрута.
     */
    public static double distanceBetweenStops(List<GeoPoint> geometry,
                                              GeoPoint fromGeoPoint,
                                              GeoPoint toGeoPoint) {
        List<GeoPoint> pointsBetweenStops = getPointsBetweenStops(geometry, fromGeoPoint, toGeoPoint);
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
    private static double distanceBetweenPoints(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);
        return EARTH_RADIUS * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }

    /**
     * Метод расчета расстояния по прямой между двумя точками (обертка над {@link #distanceBetweenPoints}).
     *
     * @param geoPoint1 первая точка.
     * @param geoPoint2 вторая точка.
     * @return расстояние по прямой между точками.
     */
    private static double distanceBetweenPoints(GeoPoint geoPoint1, GeoPoint geoPoint2) {
        return distanceBetweenPoints(geoPoint1.latitude, geoPoint1.longitude, geoPoint2.latitude, geoPoint2.longitude);
    }

    /**
     * Метод расчета суммарного расстояния маршрута, заданного в виде списка точек (геометрия маршрута).
     *
     * @param points геометрия маршрута.
     * @return расстояние маршрута.
     */
    private static double totalDistance(List<GeoPoint> points) {
        double sum = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            GeoPoint from = points.get(i);
            GeoPoint to = points.get(i + 1);
            sum += distanceBetweenPoints(from.latitude, from.longitude, to.latitude, to.longitude);
        }
        return sum;
    }

    /**
     * Метод получения индекса ближайшей точки из списка к переданной точке.
     *
     * @param geoPoint точка, к которой нужно найти ближайшую из списка.
     * @param points   список точек (геометрия маршрута, задан порядок).
     * @return индекс ближайшей точки из списка.
     */
    private static int getIndexOfClosestPoint(GeoPoint geoPoint, List<GeoPoint> points) {
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
        int closestFromIndex = getIndexOfClosestPoint(from, points);
        int closestToIndex = getIndexOfClosestPoint(to, points);
        // точки маршрута, не включая ближайшие
        List<GeoPoint> result = closestFromIndex == closestToIndex ?
                new ArrayList<>() :
                new ArrayList<>(points.subList(closestFromIndex + 1, closestToIndex));
        // обрамляем точки маршрута по краям точками остановок отправления и прибытия
        result.add(0, from);
        result.add(to);
        return result;
    }

}