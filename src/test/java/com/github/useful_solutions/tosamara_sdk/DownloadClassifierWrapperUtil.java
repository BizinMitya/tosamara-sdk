package com.github.useful_solutions.tosamara_sdk;

import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequest;
import com.github.useful_solutions.tosamara_sdk.classifier.ClassifierRequestImpl;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.*;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class DownloadClassifierWrapperUtil {

    private static final ClassifierRequest CLASSIFIER_REQUEST = new ClassifierRequestImpl();
    private static final String PATH_TO_DIR = "src/test/resources/";

    private DownloadClassifierWrapperUtil() {
    }

    @Test
    void downloadAllClassifiers() {
        try {
            Serializer serializer = new Persister(new AnnotationStrategy());
            createDirIfNeeded();

            StopWrapper stopWrapper = new StopWrapper();
            stopWrapper.stops = CLASSIFIER_REQUEST.getStops();
            serializer.write(stopWrapper, new File(PATH_TO_DIR + "stops.xml"));

            FullStopWrapper fullStopWrapper = new FullStopWrapper();
            fullStopWrapper.fullStops = CLASSIFIER_REQUEST.getFullStops();
            serializer.write(fullStopWrapper, new File(PATH_TO_DIR + "fullStops.xml"));
            createShortDescriptionForStops(fullStopWrapper.fullStops);

            RouteWrapper routeWrapper = new RouteWrapper();
            routeWrapper.routes = CLASSIFIER_REQUEST.getRoutes();
            serializer.write(routeWrapper, new File(PATH_TO_DIR + "routes.xml"));

            RouteWithStopsWrapper routeWithStopsWrapper = new RouteWithStopsWrapper();
            routeWithStopsWrapper.routeWithStops = CLASSIFIER_REQUEST.getRoutesWithStops();
            serializer.write(routeWithStopsWrapper, new File(PATH_TO_DIR + "routesWithStops.xml"));

            serializer.write(CLASSIFIER_REQUEST.getStopsOnMap(), new File(PATH_TO_DIR + "stopsOnMap.xml"));

            RouteOnMapWrapper routeOnMapWrapper = new RouteOnMapWrapper();
            routeOnMapWrapper.routesOnMap = CLASSIFIER_REQUEST.getRoutesOnMap();
            serializer.write(routeOnMapWrapper, new File(PATH_TO_DIR + "routesOnMap.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createShortDescriptionForStops(List<FullStop> fullStops) {
        try (FileWriter fileWriter = new FileWriter(PATH_TO_DIR + "shortStops.txt")) {
            for (FullStop fullStop : fullStops) {
                StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
                stringJoiner.add(String.valueOf(fullStop.ksId));
                stringJoiner.add(fullStop.title);
                stringJoiner.add(fullStop.adjacentStreet);
                stringJoiner.add(fullStop.direction);
                stringJoiner.add(getTypeOfTransport(fullStop));
                fileWriter.write(stringJoiner.toString() + System.lineSeparator());
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

    private String getTypeOfTransport(FullStop fullStop) {
        List<String> types = new ArrayList<>();
        if (fullStop.trams != null && !fullStop.trams.isEmpty()) {
            types.add("трамваи");
        }
        if (fullStop.busesCommercial != null && !fullStop.busesCommercial.isEmpty()) {
            types.add("коммерческие автобусы");
        }
        if (fullStop.busesIntercity != null && !fullStop.busesIntercity.isEmpty()) {
            types.add("междугородние автобусы");
        }
        if (fullStop.busesMunicipal != null && !fullStop.busesMunicipal.isEmpty()) {
            types.add("муниципальные автобусы");
        }
        if (fullStop.busesPrigorod != null && !fullStop.busesPrigorod.isEmpty()) {
            types.add("пригородные автобусы");
        }
        if (fullStop.busesSeason != null && !fullStop.busesSeason.isEmpty()) {
            types.add("сезонные автобусы");
        }
        if (fullStop.busesSpecial != null && !fullStop.busesSpecial.isEmpty()) {
            types.add("специальные автобусы");
        }
        if (fullStop.riverTransports != null && !fullStop.riverTransports.isEmpty()) {
            types.add("речной транспорт");
        }
        if (fullStop.trolleybuses != null && !fullStop.trolleybuses.isEmpty()) {
            types.add("троллейбусы");
        }
        if (fullStop.electricTrains != null && !fullStop.electricTrains.isEmpty()) {
            types.add("электрички");
        }
        if (fullStop.metros != null && !fullStop.metros.isEmpty()) {
            types.add("метро");
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "(", ")");
        stringJoiner.setEmptyValue("-");
        types.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }

}
