package algorithm;

import algorithm.pojo.Route;
import algorithm.pojo.Transport;
import algorithm.pojo.TransportType;
import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.FullStop;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutesMatrix {

    private static Transport[][] matrix;
    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();

    private RoutesMatrix() {
    }

    public static Transport[][] getMatrix() {
        if (matrix == null) {
            matrix = calculateMatrix();
        }
        return matrix;
    }

    @Nullable
    private static Transport[][] calculateMatrix() {
        try {
            List<FullStop> fullStops = CLASSIFIER_REQUEST.getFullStops();
            int size = fullStops.stream().map(fullStop -> fullStop.ksId).max(Integer::compare).get();
            Transport[][] matrix = new Transport[size][size];
            for (int i = 0; i < fullStops.size(); i++) {
                for (int j = i; j < fullStops.size(); j++) {
                    int indexI = fullStops.get(i).ksId - 1;
                    int indexJ = fullStops.get(j).ksId - 1;
                    Transport transport = createTransport(fullStops.get(i), fullStops.get(j));
                    matrix[indexI][indexJ] = transport;
                    matrix[indexJ][indexI] = transport;
                }
            }
            return matrix;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    private static Transport createTransport(FullStop fullStop1, FullStop fullStop2) {
        List<Route> routes = new ArrayList<>();
        routes.add(new Route(intersection(fullStop1.busesCommercial, fullStop2.busesCommercial), TransportType.busesCommercial));
        routes.add(new Route(intersection(fullStop1.busesIntercity, fullStop2.busesIntercity), TransportType.busesIntercity));
        routes.add(new Route(intersection(fullStop1.busesMunicipal, fullStop2.busesMunicipal), TransportType.busesMunicipal));
        routes.add(new Route(intersection(fullStop1.busesPrigorod, fullStop2.busesPrigorod), TransportType.busesPrigorod));
        routes.add(new Route(intersection(fullStop1.busesSeason, fullStop2.busesSeason), TransportType.busesSeason));
        routes.add(new Route(intersection(fullStop1.busesSpecial, fullStop2.busesSpecial), TransportType.busesSpecial));
        routes.add(new Route(intersection(fullStop1.electricTrains, fullStop2.electricTrains), TransportType.electricTrains));
        routes.add(new Route(intersection(fullStop1.metros, fullStop2.metros), TransportType.metros));
        routes.add(new Route(intersection(fullStop1.riverTransports, fullStop2.riverTransports), TransportType.riverTransports));
        routes.add(new Route(intersection(fullStop1.trams, fullStop2.trams), TransportType.trams));
        routes.add(new Route(intersection(fullStop1.trolleybuses, fullStop2.trolleybuses), TransportType.trolleybuses));
        routes = routes.stream()
                .filter(route -> route.getNumbers() != null)
                .collect(Collectors.toList());
        if (routes.isEmpty()) {
            return null;
        } else {
            return new Transport(routes);
        }
    }

    @Nullable
    private static <T> List<T> intersection(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null) {
            return null;
        } else {
            List<T> list = new ArrayList<>();

            for (T t : list1) {
                if (list2.contains(t)) {
                    list.add(t);
                }
            }

            return list;
        }
    }

}
