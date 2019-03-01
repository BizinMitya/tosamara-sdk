package com.github.useful_solutions.tosamara_sdk.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.*;
import com.github.useful_solutions.tosamara_sdk.api.record.request.*;
import com.github.useful_solutions.tosamara_sdk.api.record.response.*;
import com.github.useful_solutions.tosamara_sdk.exception.APIResponseException;
import com.squareup.okhttp.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

public class APIRequestImpl implements APIRequest {

    private static final String API_URL = "https://tosamara.ru/api/v2/json";
    private static final String TEST_AUTH_KEY_URL = "https://tosamara.ru/test_files/api/handler.php";

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .registerModule(new JavaTimeModule());

    private final String clientId;
    private final String key;
    private final String os;

    /**
     * @param clientId идентификатор клиента.
     * @param key      ключ.
     * @param os       операционная система, с которой будут отправляться запросы.
     */
    public APIRequestImpl(@NotNull String clientId, @NotNull String key, @NotNull String os) {
        this.clientId = clientId;
        this.key = key;
        this.os = os;
    }

    /**
     * Для запросов к API будет использоваться тестовый ключ.
     * В качестве операционной системы будет использоваться "android".
     */
    public APIRequestImpl() {
        this("android");
    }

    /**
     * Для запросов к API будет использоваться тестовый ключ.
     *
     * @param os операционная система, с которой будут отправляться запросы.
     */
    public APIRequestImpl(@NotNull String os) {
        clientId = "test";
        key = null;
        this.os = os;
    }

    @Override
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count) throws APIResponseException, IOException {
        GetFirstArrivalToStopRequest request = new GetFirstArrivalToStopRequest(ksIds, count);
        return doRequest(request, GetFirstArrivalToStopResponse.class);
    }

    @Override
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count) throws APIResponseException, IOException {
        return getFirstArrivalToStop(Collections.singletonList(ksId), count);
    }

    @Override
    public GetRouteArrivalToStopResponse getRouteArrivalToStop(Integer ksId, Integer krId) throws APIResponseException, IOException {
        GetRouteArrivalToStopRequest request = new GetRouteArrivalToStopRequest(ksId, krId);
        return doRequest(request, GetRouteArrivalToStopResponse.class);
    }

    @Override
    public GetRouteScheduleResponse getRouteSchedule(Integer krId, String day) throws APIResponseException, IOException {
        GetRouteScheduleRequest request = new GetRouteScheduleRequest(krId, day);
        return doRequest(request, GetRouteScheduleResponse.class);
    }

    @Override
    public FindShortestPathResponse findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2,
                                                     FindShortestPathRequest.Criterion criterion, TransportType... transports) throws APIResponseException, IOException {
        FindShortestPathRequest request = new FindShortestPathRequest(geoPoint1, geoPoint2, criterion, transports);
        return doRequest(request, FindShortestPathResponse.class);
    }

    @Override
    public GetTransportPositionResponse getTransportPosition(Integer hullNo) throws APIResponseException, IOException {
        GetTransportPositionRequest request = new GetTransportPositionRequest(hullNo);
        return doRequest(request, GetTransportPositionResponse.class);
    }

    @Override
    public List<Transport> getSurroundingTransports(GeoPoint geoPoint, Double radius, Integer count) throws APIResponseException, IOException {
        GetSurroundingTransportsRequest request = new GetSurroundingTransportsRequest(geoPoint, radius, count);
        GetSurroundingTransportsResponse response = doRequest(request, GetSurroundingTransportsResponse.class);
        return response.transports;
    }

    @Override
    public List<Transport> getTransportsOnRoute(List<Integer> krIds, Integer count) throws APIResponseException, IOException {
        GetTransportsOnRouteRequest request = new GetTransportsOnRouteRequest(krIds, count);
        GetTransportsOnRouteResponse response = doRequest(request, GetTransportsOnRouteResponse.class);
        return response.transports;
    }

    @Override
    public List<Transport> getTransportsOnRoute(Integer krId, Integer count) throws APIResponseException, IOException {
        return getTransportsOnRoute(Collections.singletonList(krId), count);
    }

    public List<Building> getNearestBuilding(GeoPoint geoPoint, Double radius, Integer count) throws APIResponseException, IOException {
        GetNearestBuildingRequest request = new GetNearestBuildingRequest(geoPoint, radius, count);
        GetNearestBuildingResponse response = doRequest(request, GetNearestBuildingResponse.class);
        return response.buildings;
    }

    public List<Building> findBuildingByAddress(@Nullable GeoPoint geoPoint, String address, Integer count) throws APIResponseException, IOException {
        FindBuildingByAddressRequest request = new FindBuildingByAddressRequest(geoPoint, address, count);
        FindBuildingByAddressResponse response = doRequest(request, FindBuildingByAddressResponse.class);
        return response.buildings;
    }

    public List<Message> getUserMessages(GeoPoint geoPoint, Double radius, String deviceId) throws APIResponseException, IOException {
        GetUserMessagesRequest request = new GetUserMessagesRequest(geoPoint, radius, deviceId);
        GetUserMessagesResponse response = doRequest(request, GetUserMessagesResponse.class);
        return response.messages;
    }

    public VoteForMessageResponse voteForMessage(Integer id, Message.Vote vote, GeoPoint geoPoint, String deviceId) throws APIResponseException, IOException {
        VoteForMessageRequest request = new VoteForMessageRequest(id, vote, geoPoint, deviceId);
        return doRequest(request, VoteForMessageResponse.class);
    }

    public SendUserMessageResponse sendUserMessage(String text, String textEn, String link,
                                                   List<Link> links, Integer expireTime, String deviceId) throws APIResponseException, IOException {
        SendUserMessageRequest request = new SendUserMessageRequest(text, textEn, link, links, expireTime, deviceId);
        return doRequest(request, SendUserMessageResponse.class);
    }

    private <T> T doRequest(Object request, Class<T> responseType) throws APIResponseException, IOException {
        String rawData = doAPIRequest(getFormParams(OBJECT_MAPPER.writeValueAsString(request)));
        return OBJECT_MAPPER.readValue(rawData, responseType);
    }

    /**
     * Метод создания тела HTTP-запроса в виде формы.
     *
     * @param message сообщение.
     * @return тело запроса.
     */
    private RequestBody getFormParams(String message) throws IOException, APIResponseException {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        formEncodingBuilder.add("os", os);
        formEncodingBuilder.add("message", message);
        formEncodingBuilder.add("clientId", clientId);
        String authKey = (key == null ? getTestAuthKey(message) : DigestUtils.shaHex(message + key));
        formEncodingBuilder.add("authKey", authKey);
        return formEncodingBuilder.build();
    }

    /**
     * Метод получения тестового ключа.
     *
     * @param message сообщение серверу.
     * @return тестовый ключ.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка запроса.
     */
    private String getTestAuthKey(String message) throws IOException, APIResponseException {
        FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
        formEncodingBuilder.add("msg", message);
        Response response = OK_HTTP_CLIENT.newCall(
                new Request.Builder()
                        .url(TEST_AUTH_KEY_URL)
                        .post(formEncodingBuilder.build())
                        .build()
        ).execute();
        return handleResponse(response);
    }

    private String doAPIRequest(RequestBody requestBody) throws APIResponseException, IOException {
        Response response = OK_HTTP_CLIENT.newCall(
                new Request.Builder()
                        .url(API_URL)
                        .post(requestBody).build()
        ).execute();
        return handleResponse(response);
    }

    private String handleResponse(Response response) throws IOException, APIResponseException {
        int statusCode = response.code();
        if (statusCode != HTTP_OK) {
            throw new APIResponseException(statusCode);
        }
        return response.body().string();
    }

}
