import classifier.ClassifierRequest;
import classifier.ClassifierRequestImpl;
import classifier.pojo.*;
import classifier.transformer.StringToArrayTransform;
import classifier.transformer.StringToGeoPointArrayTransform;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DownloadClassifiersUtil {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final String PATH_TO_DIR = "src/test/resources/";

    private DownloadClassifiersUtil() {
    }

    @Test
    void downloadAllClassifiers() {
        try {
            RegistryMatcher matchers = new RegistryMatcher();
            matchers.bind(ArrayList.class, StringToGeoPointArrayTransform.class);
            matchers.bind(ArrayList.class, StringToArrayTransform.class);
            Serializer serializer = new Persister(new AnnotationStrategy(), matchers);
            createDirIfNeeded();

            Stops stops = new Stops();
            stops.stops = CLASSIFIER_REQUEST.getStops();
            serializer.write(stops, new File(PATH_TO_DIR + "stops.xml"));

            FullStops fullStops = new FullStops();
            fullStops.fullStops = CLASSIFIER_REQUEST.getFullStops();
            serializer.write(fullStops, new File(PATH_TO_DIR + "fullStops.xml"));
            createShortDescriptionForStops(fullStops.fullStops);

            Routes routes = new Routes();
            routes.routes = CLASSIFIER_REQUEST.getRoutes();
            serializer.write(routes, new File(PATH_TO_DIR + "routes.xml"));

            RoutesWithStops routesWithStops = new RoutesWithStops();
            routesWithStops.routeWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
            serializer.write(routesWithStops, new File(PATH_TO_DIR + "routesWithStops.xml"));

            serializer.write(CLASSIFIER_REQUEST.getStopsOnMap(), new File(PATH_TO_DIR + "stopsOnMap.xml"));

            RoutesOnMap routesOnMap = new RoutesOnMap();
            routesOnMap.routesOnMap = CLASSIFIER_REQUEST.getRoutesOnMap();
            serializer.write(routesOnMap, new File(PATH_TO_DIR + "routesOnMap.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createShortDescriptionForStops(List<FullStop> fullStops) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_DIR + "shortStops.txt")) {
            for (FullStop fullStop : fullStops) {
                fileWriter.write(fullStop.ksId + "," +
                        fullStop.title + "," +
                        fullStop.adjacentStreet + ","
                        + fullStop.direction + "," +
                        (fullStop.trams == null ? "автобусы" : "трамваи") +
                        System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirIfNeeded() {
        File dir = new File(PATH_TO_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

}
