package api;

import api.record.Criterion;
import api.record.TransportType;
import api.record.Vote;
import api.record.request.FindShortestPathRequest;
import api.record.request.GeoPoint;
import api.record.request.GetFirstArrivalToStopRequest;
import api.record.response.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class APIRequestImpl implements APIRequest {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    @Nullable
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, Integer count) {
        try {
            GetFirstArrivalToStopRequest request = new GetFirstArrivalToStopRequest(ksIds, count);
            String result = doRequest(OBJECT_MAPPER.writeValueAsString(request));
            if (result != null) {
                return OBJECT_MAPPER.readValue(result, GetFirstArrivalToStopResponse.class);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count) {
        return getFirstArrivalToStop(Collections.singletonList(ksId), count);
    }

    public void getRouteArrivalToStop(Integer ksId, Integer krId) {

    }

    public void getRouteSchedule(Integer krId, String day) {

    }

    public FindShortestPathResponse findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2,
                                                     Criterion criterion, TransportType... transports) {
        try {
            FindShortestPathRequest request = new FindShortestPathRequest(geoPoint1, geoPoint2, criterion, transports);
            String rawData = doRequest(OBJECT_MAPPER.writeValueAsString(request));
            if (rawData != null) {
                return OBJECT_MAPPER.readValue(rawData, FindShortestPathResponse.class);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public void getTransportPosition(String hullNo) {

    }

    public void getSurroundingTransports(GeoPoint geoPoint, Integer radius, Integer count) {

    }

    public void getTransportsOnRoute(List<Integer> krIds, Integer count) {

    }

    public void getNearestBuilding(GeoPoint geoPoint, Integer radius, Integer count) {

    }

    public void findBuildingByAddress(GeoPoint geoPoint, String address, Integer count) {

    }

    public void getUserMessages(GeoPoint geoPoint, Integer radius, String deviceId) {

    }

    public void voteForMessage(Integer id, Vote vote, GeoPoint geoPoint, String deviceId) {

    }

    public void sendUserMessage(String text, String textEn, String link, GeoPoint geoPoint, Integer radius, Integer ksId, Integer transportHullNo, Integer expireTime, String deviceId) {

    }

    @Nullable
    @Override
    public Classifiers getClassifiers() {
        try {
            Response response = Request.Get(CLASSIFIERS_URI)
                    .execute();
            Serializer serializer = new Persister();
            HttpResponse httpResponse = response.returnResponse();
            if (httpResponse.getStatusLine().getStatusCode() == SC_OK) {
                return serializer.read(Classifiers.class, httpResponse.getEntity().getContent());
            } else {
                LOGGER.error("response code: " + httpResponse.getStatusLine().getStatusCode());
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Stops getStops() {
        try {
            Response response = Request.Get(STOPS_URI)
                    .execute();
            Serializer serializer = new Persister();
            HttpResponse httpResponse = response.returnResponse();
            if (httpResponse.getStatusLine().getStatusCode() == SC_OK) {
                return serializer.read(Stops.class, httpResponse.getEntity().getContent());
            } else {
                LOGGER.error("response code: " + httpResponse.getStatusLine().getStatusCode());
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public FullStops getFullStops() {
        try {
            Response response = Request.Get(STOPS_FULL_URI)
                    .execute();
            Serializer serializer = new Persister();
            HttpResponse httpResponse = response.returnResponse();
            if (httpResponse.getStatusLine().getStatusCode() == SC_OK) {
                return serializer.read(FullStops.class, httpResponse.getEntity().getContent());
            } else {
                LOGGER.error("response code: " + httpResponse.getStatusLine().getStatusCode());
                return null;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}
