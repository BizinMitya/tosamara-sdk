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
import com.github.useful_solutions.tosamara_sdk.util.HttpConnectionManager;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * <a href="https://tosamara.ru/api">https://tosamara.ru/api</a>
 */
public class ToSamaraAPI {

    private static final String API_URL = "https://tosamara.ru/api/json";
    private static final String TEST_AUTH_KEY_URL = "https://tosamara.ru/test_files/api/handler.php";

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
    public ToSamaraAPI(@NotNull String clientId, @NotNull String key, @NotNull String os) {
        this.clientId = clientId;
        this.key = key;
        this.os = os;
    }

    /**
     * Для запросов к API будет использоваться тестовый ключ.
     * В качестве операционной системы будет использоваться "android".
     */
    public ToSamaraAPI() {
        this("android");
    }

    /**
     * Для запросов к API будет использоваться тестовый ключ.
     *
     * @param os операционная система, с которой будут отправляться запросы.
     */
    public ToSamaraAPI(@NotNull String os) {
        clientId = "test";
        key = null;
        this.os = os;
    }

    /**
     * Метод получения прогнозов прибытия транспорта на выбранные остановки.
     * Запрос на несколько остановок сразу, результаты упорядочиваются по времени прибытия.
     *
     * @param ksIds классификаторные номера остановок.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count) throws APIResponseException, IOException {
        GetFirstArrivalToStopRequest request = new GetFirstArrivalToStopRequest(ksIds, count);
        return doRequest(request, GetFirstArrivalToStopResponse.class);
    }

    /**
     * Метод получения прогнозов прибытия транспорта на выбранную остановку.
     *
     * @param ksId  классификаторный номер остановки.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count) throws APIResponseException, IOException {
        return getFirstArrivalToStop(Collections.singletonList(ksId), count);
    }

    /**
     * Метод получения информации о прибытии транспортных средств выбранного маршрута на выбранную остановку.
     *
     * @param ksId классификаторный номер остановки.
     * @param krId классификаторный номер маршрута.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public GetRouteArrivalToStopResponse getRouteArrivalToStop(Integer ksId, Integer krId) throws APIResponseException, IOException {
        GetRouteArrivalToStopRequest request = new GetRouteArrivalToStopRequest(ksId, krId);
        return doRequest(request, GetRouteArrivalToStopResponse.class);
    }

    /**
     * Метод получения плановых расписаний движения маршрута на текущий день.
     *
     * @param krId классификаторный номер маршрута.
     * @param day  дата, на которую нужно получить расписание, в формате ДД.ММ.ГГГГ.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public GetRouteScheduleResponse getRouteSchedule(Integer krId, String day) throws APIResponseException, IOException {
        GetRouteScheduleRequest request = new GetRouteScheduleRequest(krId, day);
        return doRequest(request, GetRouteScheduleResponse.class);
    }

    /**
     * Метод поиска лучшего маршрута проезда на общественном транспорте.
     *
     * @param geoPoint1  координаты начальной точки маршрута в WGS 84.
     * @param geoPoint2  координаты конечной точки маршрута в WGS 84.
     * @param criterion  критерий оптимальности, одно из значений.
     * @param transports допустимые типы транспорта, набор значений через запятую.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public FindShortestPathResponse findShortestPath(GeoPoint geoPoint1,
                                                     GeoPoint geoPoint2,
                                                     FindShortestPathRequest.Criterion criterion,
                                                     TransportType... transports) throws APIResponseException, IOException {
        FindShortestPathRequest request = new FindShortestPathRequest(geoPoint1, geoPoint2, criterion, transports);
        return doRequest(request, FindShortestPathResponse.class);
    }

    /**
     * Метод дает информацию, на каком маршруте находится указанное транспортное средство, и сколько времени оно будет двигаться до последующих остановок.
     *
     * @param hullNo идентификатор транспорта, тот же самый, что в ответах
     *               {@link #getFirstArrivalToStop(List, Integer)},
     *               {@link #getFirstArrivalToStop(Integer, Integer)} и других методов.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public GetTransportPositionResponse getTransportPosition(Integer hullNo) throws APIResponseException, IOException {
        GetTransportPositionRequest request = new GetTransportPositionRequest(hullNo);
        return doRequest(request, GetTransportPositionResponse.class);
    }

    /**
     * Метод дает информацию о положении транспортов в окрестности пользователя.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Transport> getSurroundingTransports(GeoPoint geoPoint, Double radius, Integer count) throws APIResponseException, IOException {
        GetSurroundingTransportsRequest request = new GetSurroundingTransportsRequest(geoPoint, radius, count);
        GetSurroundingTransportsResponse response = doRequest(request, GetSurroundingTransportsResponse.class);
        return response.transports;
    }

    /**
     * Метод дает информацию о положении транспортов на указанных маршрутах.
     *
     * @param krIds классификаторные номера маршрутов.
     * @param count максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Transport> getTransportsOnRoute(List<Integer> krIds, Integer count) throws APIResponseException, IOException {
        GetTransportsOnRouteRequest request = new GetTransportsOnRouteRequest(krIds, count);
        GetTransportsOnRouteResponse response = doRequest(request, GetTransportsOnRouteResponse.class);
        return response.transports;
    }

    /**
     * Метод дает информацию о положении транспортов на указанном маршруте.
     *
     * @param krId  классификаторный номер маршрута.
     * @param count максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Transport> getTransportsOnRoute(Integer krId, Integer count) throws APIResponseException, IOException {
        return getTransportsOnRoute(Collections.singletonList(krId), count);
    }

    /**
     * Метод дает информацию о ближайших зданиях с адресом в окрестности указанной точки.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список зданий.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Building> getNearestBuilding(GeoPoint geoPoint, Double radius, Integer count) throws APIResponseException, IOException {
        GetNearestBuildingRequest request = new GetNearestBuildingRequest(geoPoint, radius, count);
        GetNearestBuildingResponse response = doRequest(request, GetNearestBuildingResponse.class);
        return response.buildings;
    }

    /**
     * Метод дает информацию о зданиях по строке с нечетким почтовым адресом.
     * Если заданы координаты пользователя, то результаты упорядочиваются по удаленности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param address  поисковая строчка с адресом.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список зданий.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Building> findBuildingByAddress(@Nullable GeoPoint geoPoint, String address, Integer count) throws APIResponseException, IOException {
        FindBuildingByAddressRequest request = new FindBuildingByAddressRequest(geoPoint, address, count);
        FindBuildingByAddressResponse response = doRequest(request, FindBuildingByAddressResponse.class);
        return response.buildings;
    }

    /**
     * Метод возвращает список пользовательских сообщений в указанной окрестности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус окрестности, по которой собираются события, в метрах.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     * @return список сообщений.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public List<Message> getUserMessages(GeoPoint geoPoint, Double radius, String deviceId) throws APIResponseException, IOException {
        GetUserMessagesRequest request = new GetUserMessagesRequest(geoPoint, radius, deviceId);
        GetUserMessagesResponse response = doRequest(request, GetUserMessagesResponse.class);
        return response.messages;
    }

    /**
     * Метод отправляет мнение пользователя об указанном сообщении - голос подтверждения или опровержения.
     *
     * @param id       идентификатор сообщения.
     * @param vote     мнение пользователя, одно из значений.
     * @param geoPoint координаты пользователя в WGS 84, чтобы убедиться, что голосующий действительно неподалеку от сообщения.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public VoteForMessageResponse voteForMessage(Integer id,
                                                 Message.Vote vote,
                                                 GeoPoint geoPoint,
                                                 String deviceId) throws APIResponseException, IOException {
        VoteForMessageRequest request = new VoteForMessageRequest(id, vote, geoPoint, deviceId);
        return doRequest(request, VoteForMessageResponse.class);
    }

    /**
     * Метод отправляет геопривязанное пользовательское сообщение.
     *
     * @param text       текст сообщения.
     * @param textEn     текст сообщения на английском (может быть не заполнен).
     * @param link       гиперссылка на более подробный материал.
     * @param links      список координат с радиусами.
     * @param expireTime время потери актуальности сообщения в часах.
     * @param deviceId   уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     */
    public SendUserMessageResponse sendUserMessage(String text,
                                                   String textEn,
                                                   String link,
                                                   List<Link> links,
                                                   Integer expireTime,
                                                   String deviceId) throws APIResponseException, IOException {
        SendUserMessageRequest request = new SendUserMessageRequest(text, textEn, link, links, expireTime, deviceId);
        return doRequest(request, SendUserMessageResponse.class);
    }

    private <T> T doRequest(Object request, Class<T> responseType) throws APIResponseException, IOException {
        RequestBody requestBody = getFormParams(OBJECT_MAPPER.writeValueAsString(request));
        String rawData = doAPIRequest(requestBody);
        return OBJECT_MAPPER.readValue(rawData, responseType);
    }

    /**
     * Метод создания тела HTTP-запроса в виде формы.
     *
     * @param message сообщение.
     * @return тело запроса.
     */
    private RequestBody getFormParams(String message) throws IOException, APIResponseException {
        FormBody.Builder form = new FormBody.Builder();
        form.add("os", os);
        form.add("message", message);
        form.add("clientId", clientId);
        String authKey = (key == null ? getTestAuthKey(message) : DigestUtils.shaHex(message + key));
        form.add("authKey", authKey);
        return form.build();
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
        FormBody.Builder form = new FormBody.Builder();
        form.add("msg", message);
        try (Response response = HttpConnectionManager.buildPostCall(TEST_AUTH_KEY_URL, form.build()).execute()) {
            return handleResponse(response);
        }
    }

    private String doAPIRequest(RequestBody requestBody) throws APIResponseException, IOException {
        try (Response response = HttpConnectionManager.buildPostCall(API_URL, requestBody).execute()) {
            return handleResponse(response);
        }
    }

    private String handleResponse(Response response) throws IOException, APIResponseException {
        int statusCode = response.code();
        if (statusCode != HTTP_OK) {
            throw new APIResponseException(statusCode);
        }
        try (ResponseBody responseBody = Optional.ofNullable(response.body()).orElseThrow(APIResponseException::new)) {
            return responseBody.string();
        }
    }

    private static class GetSurroundingTransportsResponse {
        public List<Transport> transports;
    }

    private static class GetTransportsOnRouteResponse {
        public List<Transport> transports;
    }

    private static class GetNearestBuildingResponse {
        public List<Building> buildings;
    }

    private static class FindBuildingByAddressResponse {
        public List<Building> buildings;
    }

    private static class GetUserMessagesResponse {
        public List<Message> messages;
    }

}
