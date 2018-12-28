package api;

import api.record.pojo.GeoPoint;
import api.record.pojo.Message;
import api.record.request.*;
import api.record.response.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class APIRequestImpl implements APIRequest {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .enable(SerializationFeature.INDENT_OUTPUT)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Nullable
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count) {
        GetFirstArrivalToStopRequest request = new GetFirstArrivalToStopRequest(ksIds, count);
        return doRequest(request, GetFirstArrivalToStopResponse.class);
    }

    @Override
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count) {
        return getFirstArrivalToStop(Collections.singletonList(ksId), count);
    }

    public GetRouteArrivalToStopResponse getRouteArrivalToStop(Integer ksId, Integer krId) {
        GetRouteArrivalToStopRequest request = new GetRouteArrivalToStopRequest(ksId, krId);
        return doRequest(request, GetRouteArrivalToStopResponse.class);
    }

    public GetRouteScheduleResponse getRouteSchedule(Integer krId, String day) {
        GetRouteScheduleRequest request = new GetRouteScheduleRequest(krId, day);
        return doRequest(request, GetRouteScheduleResponse.class);
    }

    public FindShortestPathResponse findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2,
                                                     FindShortestPathRequest.Criterion criterion, FindShortestPathRequest.TransportType... transports) {
        FindShortestPathRequest request = new FindShortestPathRequest(geoPoint1, geoPoint2, criterion, transports);
        return doRequest(request, FindShortestPathResponse.class);
    }

    public GetTransportPositionResponse getTransportPosition(Integer hullNo) {
        GetTransportPositionRequest request = new GetTransportPositionRequest(hullNo);
        return doRequest(request, GetTransportPositionResponse.class);
    }

    public GetSurroundingTransportsResponse getSurroundingTransports(GeoPoint geoPoint, Double radius, Integer count) {
        GetSurroundingTransportsRequest request = new GetSurroundingTransportsRequest(geoPoint, radius, count);
        return doRequest(request, GetSurroundingTransportsResponse.class);
    }

    public void getTransportsOnRoute(List<Integer> krIds, Integer count) {

    }

    public void getNearestBuilding(GeoPoint geoPoint, Integer radius, Integer count) {

    }

    public void findBuildingByAddress(GeoPoint geoPoint, String address, Integer count) {

    }

    public void getUserMessages(GeoPoint geoPoint, Integer radius, String deviceId) {

    }

    public void voteForMessage(Integer id, Message.Vote vote, GeoPoint geoPoint, String deviceId) {

    }

    public void sendUserMessage(String text, String textEn, String link,
                                GeoPoint geoPoint, Integer radius, Integer ksId,
                                Integer transportHullNo, Integer expireTime, String deviceId) {

    }

    private <T> T doRequest(Object request, Class<T> responseType) {
        try {
            String rawData = doAPIRequest(OBJECT_MAPPER.writeValueAsString(request));
            if (rawData != null) {
                return OBJECT_MAPPER.readValue(rawData, responseType);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

}
