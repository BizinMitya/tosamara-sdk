package com.github.useful_solutions.tosamara_sdk.classifier;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.*;
import com.github.useful_solutions.tosamara_sdk.exception.APIResponseException;
import com.github.useful_solutions.tosamara_sdk.util.HttpConnectionManager;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static java.net.HttpURLConnection.HTTP_OK;

public class ClassifierRequestImpl implements ClassifierRequest {

    private static final String CLASSIFIERS_URL = "https://tosamara.ru/api/classifiers";

    private static final String ROUTES = "routes.xml";
    private static final String STOPS = "stops.xml";
    private static final String STOPS_FULL_DB = "stopsFullDB.xml";
    private static final String ROUTES_AND_STOPS = "routesAndStopsCorrespondence.xml";
    private static final String GEOPORTAL_ROUTES = "GeoportalRoutesCorrespondence.xml";
    private static final String GEOPORTAL_STOPS = "GeoportalStopsCorrespondence.xml";

    private static final String STOPS_URL = CLASSIFIERS_URL + "/" + STOPS;
    private static final String STOPS_FULL_URL = CLASSIFIERS_URL + "/" + STOPS_FULL_DB;
    private static final String ROUTES_URL = CLASSIFIERS_URL + "/" + ROUTES;
    private static final String ROUTES_AND_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/" + ROUTES_AND_STOPS;
    private static final String GEOPORTAL_STOPS_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/" + GEOPORTAL_STOPS;
    private static final String GEOPORTAL_ROUTES_CORRESPONDENCE_URL = CLASSIFIERS_URL + "/" + GEOPORTAL_ROUTES;
    private static final String ALL_CLASSIFIERS = CLASSIFIERS_URL + "/classifiers.zip";

    private static final ObjectMapper XML_MAPPER = new XmlMapper()
            .disable(JsonParser.Feature.AUTO_CLOSE_SOURCE);

    private <T> T doClassifierRequest(Class<T> classifierType, String url) throws APIResponseException, IOException {
        try (Response response = HttpConnectionManager.buildGetCall(url).execute()) {
            int statusCode = response.code();
            if (statusCode != HTTP_OK) {
                throw new APIResponseException(statusCode);
            }
            try (ResponseBody responseBody = Optional.ofNullable(response.body()).orElseThrow(APIResponseException::new)) {
                String content = responseBody.string();
                return XML_MAPPER.readValue(content, classifierType);
            }
        }
    }

    @Override
    public List<Classifier> getClassifiers() throws APIResponseException, IOException {
        ClassifierWrapper classifierWrapper = doClassifierRequest(ClassifierWrapper.class, CLASSIFIERS_URL);
        return classifierWrapper.files;
    }

    @Override
    public AllClassifiers getAllClassifiers() throws APIResponseException, IOException {
        AllClassifiers allClassifiers = new AllClassifiers();
        try (Response response = HttpConnectionManager.buildGetCall(ALL_CLASSIFIERS).execute()) {
            int statusCode = response.code();
            if (statusCode != HTTP_OK) {
                throw new APIResponseException(statusCode);
            }
            try (ResponseBody responseBody = Optional.ofNullable(response.body()).orElseThrow(APIResponseException::new);
                 ZipInputStream zipInputStream = new ZipInputStream(responseBody.byteStream())) {
                ZipEntry zipEntry;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    switch (zipEntry.getName()) {
                        case ROUTES:
                            allClassifiers.setRoutes(XML_MAPPER.readValue(zipInputStream, RouteWrapper.class));
                            break;
                        case STOPS:
                            allClassifiers.setStops(XML_MAPPER.readValue(zipInputStream, StopWrapper.class));
                            break;
                        case STOPS_FULL_DB:
                            allClassifiers.setFullStops(XML_MAPPER.readValue(zipInputStream, FullStopWrapper.class));
                            break;
                        case ROUTES_AND_STOPS:
                            allClassifiers.setRoutesWithStops(XML_MAPPER.readValue(zipInputStream, RouteWithStopsWrapper.class));
                            break;
                        case GEOPORTAL_ROUTES:
                            allClassifiers.setRoutesOnMap(XML_MAPPER.readValue(zipInputStream, RouteOnMapWrapper.class));
                            break;
                        case GEOPORTAL_STOPS:
                            allClassifiers.setStopOnMapWrapper(XML_MAPPER.readValue(zipInputStream, StopOnMapWrapper.class));
                            break;
                    }
                    zipInputStream.closeEntry();
                }
                return allClassifiers;
            }
        }
    }

    @Override
    public List<Stop> getStops() throws APIResponseException, IOException {
        StopWrapper stopWrapper = doClassifierRequest(StopWrapper.class, STOPS_URL);
        return stopWrapper.stops;
    }

    @Override
    public List<FullStop> getFullStops() throws APIResponseException, IOException {
        FullStopWrapper fullStopWrapper = doClassifierRequest(FullStopWrapper.class, STOPS_FULL_URL);
        return fullStopWrapper.fullStops;
    }

    @Override
    public List<Route> getRoutes() throws APIResponseException, IOException {
        RouteWrapper routeWrapper = doClassifierRequest(RouteWrapper.class, ROUTES_URL);
        return routeWrapper.routes;
    }

    @Override
    public List<RouteWithStops> getRoutesWithStops() throws APIResponseException, IOException {
        RouteWithStopsWrapper routeWithStopsWrapper = doClassifierRequest(RouteWithStopsWrapper.class, ROUTES_AND_STOPS_CORRESPONDENCE_URL);
        return routeWithStopsWrapper.routeWithStops;
    }

    @Override
    public StopOnMapWrapper getStopsOnMap() throws APIResponseException, IOException {
        return doClassifierRequest(StopOnMapWrapper.class, GEOPORTAL_STOPS_CORRESPONDENCE_URL);
    }

    @Override
    public List<RouteOnMap> getRoutesOnMap() throws APIResponseException, IOException {
        RouteOnMapWrapper routeOnMapWrapper = doClassifierRequest(RouteOnMapWrapper.class, GEOPORTAL_ROUTES_CORRESPONDENCE_URL);
        return routeOnMapWrapper.routesOnMap;
    }

}
