package algorithm;

import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.RouteWithStops;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphAlgorithm {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    private GraphAlgorithm() {
    }

    // https://intellect.ml/algoritm-poiska-putej-v-grafe-4148

    /**
     * Метод нахождения всех маршрутов между двумя остановками с одной пересадкой.
     *
     * @param ksId1 ksId1 классификаторный номер остановки отправления.
     * @param ksId2 ksId2 классификаторный номер остановки прибытия.
     * @return список всех маршрутов между {@param ksId1} и {@param ksId2}.
     */
    public static List<List<RouteWithStops>> getAllRoutesBetweenTwoPoints(Integer ksId1, Integer ksId2) throws Exception {
        List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
        List<List<RouteWithStops>> result = new ArrayList<>();
        for (RouteWithStops first : routesWithStops) {
            if (first.stops.stream().map(stop -> stop.ksId).anyMatch(i -> i.equals(ksId1))) {
                for (RouteWithStops second : routesWithStops) {
                    if (second.stops.stream().map(stop -> stop.ksId).anyMatch(i -> i.equals(ksId2))) {
                        if (second.stops.stream()
                                .map(stop -> stop.ksId)
                                .anyMatch(first.stops.stream()
                                        .map(stop -> stop.ksId)
                                        .collect(Collectors.toList())::contains)) {
                            List<RouteWithStops> route = new ArrayList<>();
                            route.add(first);
                            route.add(second);
                            result.add(route);
                        }
                    }
                }
            }
        }
        return result;
    }

}
