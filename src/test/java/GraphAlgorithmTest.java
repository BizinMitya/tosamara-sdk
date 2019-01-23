import algorithm.GraphAlgorithm;
import algorithm.pojo.Node;
import api.record.pojo.TransportType;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.Route;
import classifier.pojo.Stop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

class GraphAlgorithmTest {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    @Test
    void test() {
        try {
            List<Stop> stops = CLASSIFIER_REQUEST.getStops();
            List<Route> routes = CLASSIFIER_REQUEST.getRoutes();

            Integer from = 737;
            Integer to = 646;
            List<LinkedList<Node>> chains = GraphAlgorithm.getAllRoutesBetweenTwoPoints(from, to);
            chains.forEach(chain -> {
                StringJoiner stringJoiner = new StringJoiner(" -> ");
                for (Node node : chain) {
                    switch (node.getType()) {
                        case stop: {
                            stringJoiner.add(getTitleStop(stops, node.getId()));
                            break;
                        }
                        case route: {
                            stringJoiner.add(getNumberRoute(routes, node.getId()));
                            break;
                        }
                    }
                }
                System.out.println(stringJoiner.toString());
            });
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private String getTitleStop(List<Stop> stops, Integer id) {
        return stops.stream()
                .filter(stop -> stop.ksId.equals(id))
                .findAny()
                .map(stop -> stop.title)
                .get();
    }

    private String getNumberRoute(List<Route> routes, Integer id) {
        return routes.stream()
                .filter(route -> route.krId.equals(id))
                .findAny()
                .map(route -> route.number + " (" + TransportType.convert(route.transportType) + ")")
                .get();
    }

}
