import api.APIRequest;
import api.APIRequestImpl;
import api.record.pojo.*;
import api.record.response.FindShortestPathResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static api.record.pojo.Criterion.time;
import static api.record.pojo.TransportType.*;

class FindShortestPathTest {

    private static final APIRequest API_REQUEST = new APIRequestImpl();

    @Test
    void singleRandomTest() {
        Random random = new Random();
        FullStops fullStops = API_REQUEST.getFullStops();
        FullStop firstStop = fullStops.stops.get(random.nextInt(fullStops.stops.size()));
        FullStop secondStop = fullStops.stops.get(random.nextInt(fullStops.stops.size()));
        GeoPoint firstPoint = new GeoPoint(firstStop.latitude, firstStop.longitude);
        GeoPoint secondPoint = new GeoPoint(secondStop.latitude, secondStop.longitude);
        Map<Integer, FullStop> fullStopMap = fullStops.stops.stream()
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
            for (Action action : shortestPath.actions) {
                if (action.action.equals(ActionType.walk)) {
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
