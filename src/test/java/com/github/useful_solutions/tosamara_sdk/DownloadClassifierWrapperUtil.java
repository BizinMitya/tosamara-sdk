package com.github.useful_solutions.tosamara_sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.useful_solutions.tosamara_sdk.classifier.Classifiers;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Supplier;

class DownloadClassifierWrapperUtil {

    private static final Supplier<JacksonXmlModule> JACKSON_XML_MODULE_SUPPLIER = () -> {
        JacksonXmlModule jacksonXmlModule = new JacksonXmlModule();
        jacksonXmlModule.setDefaultUseWrapper(false);
        return jacksonXmlModule;
    };
    private static final ObjectMapper XML_MAPPER = new XmlMapper(JACKSON_XML_MODULE_SUPPLIER.get())
            .enable(SerializationFeature.INDENT_OUTPUT);
    private static final String PATH_TO_DIR = "src/test/resources/";

    private DownloadClassifierWrapperUtil() {
    }

    @Test
    void downloadAllClassifiers() {
        try {
            createDirIfNeeded();

            StopWrapper stopWrapper = new StopWrapper();
            stopWrapper.stops = Classifiers.getStops();
            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "stops.xml"), stopWrapper);

            FullStopWrapper fullStopWrapper = new FullStopWrapper();
            fullStopWrapper.fullStops = Classifiers.getFullStops();
            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "fullStops.xml"), fullStopWrapper);
            createShortDescriptionForStops(fullStopWrapper.fullStops);

            RouteWrapper routeWrapper = new RouteWrapper();
            routeWrapper.routes = Classifiers.getRoutes();
            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "routes.xml"), routeWrapper);

            RouteWithStopsWrapper routeWithStopsWrapper = new RouteWithStopsWrapper();
            routeWithStopsWrapper.routeWithStops = Classifiers.getRoutesWithStops();
            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "routesWithStops.xml"), routeWithStopsWrapper);

            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "stopsOnMap.xml"), Classifiers.getStopsOnMap());

            RouteOnMapWrapper routeOnMapWrapper = new RouteOnMapWrapper();
            routeOnMapWrapper.routesOnMap = Classifiers.getRoutesOnMap();
            XML_MAPPER.writeValue(new File(PATH_TO_DIR + "routesOnMap.xml"), routeOnMapWrapper);
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
