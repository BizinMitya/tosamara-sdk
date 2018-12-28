import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.GeoPoint;
import api.record.response.FindShortestPathResponse;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.FullStop;
import classifier.pojo.FullStops;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static api.record.request.FindShortestPathRequest.Criterion.time;
import static api.record.request.FindShortestPathRequest.TransportType.*;

class FindShortestPathTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void singleRandomTest() {
        Random random = new Random();
        FullStops fullStops = CLASSIFIER_REQUEST.getFullStops();
        FullStop firstStop = fullStops.fullStops.get(random.nextInt(fullStops.fullStops.size()));
        FullStop secondStop = fullStops.fullStops.get(random.nextInt(fullStops.fullStops.size()));
        GeoPoint firstPoint = new GeoPoint(firstStop.latitude, firstStop.longitude);
        GeoPoint secondPoint = new GeoPoint(secondStop.latitude, secondStop.longitude);
        Map<Integer, FullStop> fullStopMap = fullStops.fullStops.stream()
                .collect(Collectors.toMap(fullStop -> fullStop.ksId, fullStop -> fullStop));
        try {
            FindShortestPathResponse shortestPath =
                    API_REQUEST.findShortestPath(firstPoint, secondPoint, time,
                            bus, tram, trolleybus, metro);
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
        } catch (Throwable t) {
            Assertions.fail(t);
        }
    }

}
