package algorithm;

import algorithm.pojo.Node;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.RouteWithStops;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphAlgorithm {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    private GraphAlgorithm() {
    }

    /**
     * Метод нахождения всех маршрутов между двумя остановками с одной пересадкой.
     *
     * @param ksId1 ksId1 классификаторный номер остановки отправления.
     * @param ksId2 ksId2 классификаторный номер остановки прибытия.
     * @return список всех маршрутов между {@param ksId1} и {@param ksId2}.
     */
    public static List<LinkedList<Node>> getAllRoutesBetweenTwoPoints(Integer ksId1, Integer ksId2) throws Exception {
        List<RouteWithStops> routesWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
        List<LinkedList<Node>> result = new ArrayList<>();
        for (RouteWithStops first : routesWithStops) {
            if (first.stops.stream().map(stop -> stop.ksId).anyMatch(ksId1::equals)) {
                for (RouteWithStops second : routesWithStops) {
                    List<Integer> secondIds = second.stops.stream()
                            .map(stop -> stop.ksId)
                            .collect(Collectors.toList());
                    if (secondIds.stream().anyMatch(ksId2::equals)) {
                        List<Integer> transitStops = secondIds.stream()
                                .filter(first.stops.stream()
                                        .map(stop -> stop.ksId)
                                        .collect(Collectors.toList())::contains).collect(Collectors.toList());
                        if (!transitStops.isEmpty()) {
                            for (Integer transitStop : transitStops) {
                                LinkedList<Node> chain = new LinkedList<>();
                                chain.addLast(new Node(ksId1, Node.Type.stop));
                                chain.addLast(new Node(first.krId, Node.Type.route));
                                chain.addLast(new Node(transitStop, Node.Type.stop));
                                chain.addLast(new Node(second.krId, Node.Type.route));
                                chain.addLast(new Node(ksId2, Node.Type.stop));
                                result.add(chain);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
