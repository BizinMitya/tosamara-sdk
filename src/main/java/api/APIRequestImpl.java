package api;

import api.record.Criterion;
import api.record.Transports;
import api.record.Vote;
import api.record.request.GeoPoint;
import api.record.request.GetFirstArrivalToStopRequest;
import api.record.response.Classifiers;
import api.record.response.GetFirstArrivalToStopResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.jetbrains.annotations.Nullable;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

public class APIRequestImpl implements APIRequest {

    @Nullable
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, Integer count) {
        try {
            GetFirstArrivalToStopRequest getFirstArrivalToStopRequest = new GetFirstArrivalToStopRequest(ksIds, count);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(doRequest(objectMapper.writeValueAsString(getFirstArrivalToStopRequest)), GetFirstArrivalToStopResponse.class);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public void getRouteArrivalToStop(Integer ksId, Integer krId) {

    }

    public void getRouteSchedule(Integer krId, String day) {

    }

    public void findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2, List<Transports> transports, Criterion criterion) {

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

}
