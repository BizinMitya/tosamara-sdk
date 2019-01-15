package api;

import api.record.pojo.GeoPoint;
import api.record.pojo.Link;
import api.record.pojo.Message;
import api.record.request.*;
import api.record.response.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exception.APIResponseException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class APIRequestImpl implements APIRequest {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .enable(SerializationFeature.INDENT_OUTPUT)
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private static final String CLIENT_ID = "";
    private static final String KEY = "";
    private static final Logger LOGGER = Logger.getLogger(APIRequestImpl.class);

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
                                                     FindShortestPathRequest.Criterion criterion, FindShortestPathRequest.TransportType... transports) throws APIResponseException, IOException {
        FindShortestPathRequest request = new FindShortestPathRequest(geoPoint1, geoPoint2, criterion, transports);
        return doRequest(request, FindShortestPathResponse.class);
    }

    @Override
    public GetTransportPositionResponse getTransportPosition(Integer hullNo) throws APIResponseException, IOException {
        GetTransportPositionRequest request = new GetTransportPositionRequest(hullNo);
        return doRequest(request, GetTransportPositionResponse.class);
    }

    @Override
    public GetSurroundingTransportsResponse getSurroundingTransports(GeoPoint geoPoint, Double radius, Integer count) throws APIResponseException, IOException {
        GetSurroundingTransportsRequest request = new GetSurroundingTransportsRequest(geoPoint, radius, count);
        return doRequest(request, GetSurroundingTransportsResponse.class);
    }

    @Override
    public GetTransportsOnRouteResponse getTransportsOnRoute(List<Integer> krIds, Integer count) throws APIResponseException, IOException {
        GetTransportsOnRouteRequest request = new GetTransportsOnRouteRequest(krIds, count);
        return doRequest(request, GetTransportsOnRouteResponse.class);
    }

    @Override
    public GetTransportsOnRouteResponse getTransportsOnRoute(Integer krId, Integer count) throws APIResponseException, IOException {
        return getTransportsOnRoute(Collections.singletonList(krId), count);
    }

    public GetNearestBuildingResponse getNearestBuilding(GeoPoint geoPoint, Integer radius, Integer count) throws APIResponseException, IOException {
        GetNearestBuildingRequest request = new GetNearestBuildingRequest(geoPoint, radius, count);
        return doRequest(request, GetNearestBuildingResponse.class);
    }

    public FindBuildingByAddressResponse findBuildingByAddress(@Nullable GeoPoint geoPoint, String address, Integer count) throws APIResponseException, IOException {
        FindBuildingByAddressRequest request = new FindBuildingByAddressRequest(geoPoint, address, count);
        return doRequest(request, FindBuildingByAddressResponse.class);
    }

    public GetUserMessagesResponse getUserMessages(GeoPoint geoPoint, Integer radius, String deviceId) throws APIResponseException, IOException {
        GetUserMessagesRequest request = new GetUserMessagesRequest(geoPoint, radius, deviceId);
        return doRequest(request, GetUserMessagesResponse.class);
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
        String rawData = doAPIRequest(getFormParamsForTest(OBJECT_MAPPER.writeValueAsString(request)));
        return OBJECT_MAPPER.readValue(rawData, responseType);
    }

    /**
     * Метод создает параметры формы с использованием тестового ключа.
     *
     * @param message сообщение серверу.
     * @return массив параметров формы.
     */
    private NameValuePair[] getFormParamsForTest(String message) {
        try {
            String authKey = getTestAuthKey(message);
            return new NameValuePair[]{
                    new BasicNameValuePair("clientId", "test"),
                    new BasicNameValuePair("authKey", authKey),
                    new BasicNameValuePair("os", "web"),
                    new BasicNameValuePair("message", message)
            };
        } catch (IOException | APIResponseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Метод создает параметры формы с использованием выданного ключа.
     *
     * @param message сообщение серверу.
     * @return массив параметров формы.
     */
    private NameValuePair[] getFormParams(String message) {
        return new NameValuePair[]{
                new BasicNameValuePair("clientId", CLIENT_ID),
                new BasicNameValuePair("authKey", DigestUtils.sha1Hex(message + KEY)),
                new BasicNameValuePair("os", "android"),
                new BasicNameValuePair("message", message)
        };
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
        Response response = Request.Post(TEST_AUTHKEY_URL)
                .bodyForm(new BasicNameValuePair("msg", message))
                .execute();
        return handleResponse(response);
    }

}
