package algorithm;

import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.RouteWithStops;

import java.util.List;
import java.util.stream.Collectors;

public class GraphAlgorithm {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    private GraphAlgorithm() {
    }

    /**
     * Метод нахождения всех маршрутов между двумя остановками.
     *
     * @param ksId1 список классификаторных номеров остановок отправления (разные направления одной остановки).
     * @param ksId2 список классификаторных номеров остановок прибытия (разные направления одной остановки).
     * @return список всех маршрутов между {@param ksId1} и {@param ksId2}
     */
    public static List<RouteWithStops> getAllRoutesBetweenTwoPoints(List<Integer> ksId1, List<Integer> ksId2) throws Exception {
        List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
        return routesWithStops.stream()
                .filter(routeWithStops ->
                        routeWithStops.stops.stream()
                                .anyMatch(stop -> ksId1.contains(stop.ksId) || ksId2.contains(stop.ksId))
                ).collect(Collectors.toList());
    }

}
