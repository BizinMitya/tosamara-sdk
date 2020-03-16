package com.github.useful_solutions.tosamara_sdk.calculate;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.classifier.Classifiers;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.FullStop;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.RouteWithStops;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DistanceUtil {

    private static Map<Integer, FullStop> FULL_STOP_MAP;// ksId -> FullStop
    private static Map<Integer, RouteWithStops> ROUTE_WITH_STOPS_MAP;// krId -> RouteWithStops

    static {
        try {
            FULL_STOP_MAP = Classifiers.getFullStops().stream()
                    .collect(Collectors.toMap(fullStop -> fullStop.ksId, fullStop -> fullStop));
            ROUTE_WITH_STOPS_MAP = Classifiers.getRoutesWithStops().stream()
                    .collect(Collectors.toMap(routeWithStops -> routeWithStops.krId, routeWithStops -> routeWithStops));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DistanceUtil() {
    }

    /**
     * Метод вывода информации о расстояниях между остановками по пути следования
     *
     * @param fromKsId классификаторный номер остановки отправления
     * @param toKsId   классификаторный номер остановки прибытия
     * @param krId     классификаторный номер маршрута
     */
    public static void printStepByInfoAboutJourney(int fromKsId, int toKsId, int krId) {
        RouteWithStops routeWithStops = ROUTE_WITH_STOPS_MAP.get(krId);
        int fromIndex = 0, toIndex = 0;
        for (int i = 0; i < routeWithStops.stops.size(); i++) {
            if (routeWithStops.stops.get(i).ksId.equals(fromKsId)) {
                fromIndex = i;
            }
            if (routeWithStops.stops.get(i).ksId.equals(toKsId)) {
                toIndex = i;
            }
        }

        Map<FullStop, GeoPoint> fullStopGeoPointMap = routeWithStops.stops.subList(fromIndex, toIndex + 1).stream()
                .collect(Collectors.toMap(
                        stop -> FULL_STOP_MAP.get(stop.ksId),
                        stop -> {
                            FullStop fullStop = FULL_STOP_MAP.get(stop.ksId);
                            return new GeoPoint(fullStop.latitude, fullStop.longitude);
                        },
                        (x, y) -> y,
                        LinkedHashMap::new)
                );
        List<Map.Entry<FullStop, GeoPoint>> entryList = new ArrayList<>(fullStopGeoPointMap.entrySet());

        for (int i = 0; i < entryList.size() - 1; i++) {
            Map.Entry<FullStop, GeoPoint> fromEntry = entryList.get(i);
            Map.Entry<FullStop, GeoPoint> toEntry = entryList.get(i + 1);
            DistanceInfo distanceInfo = CalculateUtil.distanceBetweenStops(routeWithStops.geometry, fromEntry.getValue(), toEntry.getValue());
            String info = "Расстояние от " + fromEntry.getKey().title + " до " + toEntry.getKey().title + ": " +
                    distanceInfo.getDistance() + " м." + (distanceInfo.isCrowflight() ? " (по прямой)" : "");
            System.out.println(info);
        }
    }

}
