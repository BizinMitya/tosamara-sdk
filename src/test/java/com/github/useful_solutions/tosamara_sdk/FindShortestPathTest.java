package com.github.useful_solutions.tosamara_sdk;

import com.github.useful_solutions.tosamara_sdk.api.APIRequest;
import com.github.useful_solutions.tosamara_sdk.api.APIRequestImpl;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.github.useful_solutions.tosamara_sdk.api.record.request.FindShortestPathRequest;
import com.github.useful_solutions.tosamara_sdk.api.record.response.FindShortestPathResponse;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequest;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.FullStop;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequestImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

class FindShortestPathTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void singleRandomTest() {
        try {
            Random random = new Random();
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops();
            FullStop firstStop = fullStops.get(random.nextInt(fullStops.size()));
            FullStop secondStop = fullStops.get(random.nextInt(fullStops.size()));
            GeoPoint firstPoint = new GeoPoint(firstStop.latitude, firstStop.longitude);
            GeoPoint secondPoint = new GeoPoint(secondStop.latitude, secondStop.longitude);
            Map<Integer, FullStop> fullStopMap = fullStops.stream()
                    .collect(Collectors.toMap(fullStop -> fullStop.ksId, fullStop -> fullStop));
            FindShortestPathResponse shortestPath =
                    API_REQUEST.findShortestPath(firstPoint, secondPoint, FindShortestPathRequest.Criterion.time,
                            TransportType.bus, TransportType.tram, TransportType.trolleybus, TransportType.metro);
            System.out.println("Маршрут от " + firstStop.title + " до " + secondStop.title);
            if (shortestPath.price == null) {
                System.out.println("Маршрута не существует");
                return; // пустой объект вернулся
            }
            System.out.println("Общее время: " + shortestPath.time + " сек., цена: " + shortestPath.price + " руб.");
            int order = 1;
            for (FindShortestPathResponse.Action action : shortestPath.actions) {
                if (action.action.equals(FindShortestPathResponse.Action.ActionType.walk)) {
                    System.out.println(order + ") " + action.comment + ", время: " + action.time + " сек.");
                } else {
                    System.out.println(order + ") " +
                            "от " + (action.stopFrom != null ? fullStopMap.get(action.stopFrom).title : firstStop.title) +
                            " до " + fullStopMap.get(action.stopTo).title + ", " + action.comment + ", время: " + action.time + " сек.");
                }
                order++;
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
