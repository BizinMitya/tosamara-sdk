package api;

import api.record.pojo.Criterion;
import api.record.pojo.GeoPoint;
import api.record.pojo.TransportType;
import api.record.pojo.Vote;
import api.record.response.FindShortestPathResponse;
import api.record.response.GetFirstArrivalToStopResponse;
import api.record.response.GetRouteArrivalToStopResponse;
import api.record.response.GetRouteScheduleResponse;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

/**
 * http://www.tosamara.ru/api/
 */
public interface APIRequest {

    String BASE_URL = "http://tosamara.ru/api";
    String API_URL = BASE_URL + "/v2/json";

    String CLIENT_ID = "";
    String KEY = "";

    Logger LOGGER = Logger.getLogger(APIRequest.class);

    /**
     * Метод получения прогнозов прибытия транспорта на выбранные остановки.
     * Запрос на несколько остановок сразу, результаты упорядочиваются по времени прибытия.
     *
     * @param ksIds классификаторные номера остановок.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     */
    GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count);

    /**
     * Метод получения прогнозов прибытия транспорта на выбранную остановку.
     *
     * @param ksId  классификаторный номер остановки.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     */
    GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count);

    /**
     * Метод получения информации о прибытии транспортных средств выбранного маршрута на выбранную остановку.
     *
     * @param ksId классификаторный номер остановки.
     * @param krId классификаторный номер маршрута.
     * @return объект ответа.
     */
    GetRouteArrivalToStopResponse getRouteArrivalToStop(Integer ksId, Integer krId);

    /**
     * Метод получения плановых расписаний движения маршрута на текущий день.
     *
     * @param krId классификаторный номер маршрута.
     * @param day  дата, на которую нужно получить расписание, в формате ДД.ММ.ГГГГ.
     * @return объект ответа.
     */
    GetRouteScheduleResponse getRouteSchedule(Integer krId, String day);

    /**
     * Метод поиска лучшего маршрута проезда на общественном транспорте.
     *
     * @param geoPoint1  координаты начальной точки маршрута в WGS 84.
     * @param geoPoint2  координаты конечной точки маршрута в WGS 84.
     * @param criterion  критерий оптимальности, одно из значений.
     * @param transports допустимые типы транспорта, набор значений через запятую.
     * @return объект ответа.
     */
    FindShortestPathResponse findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2,
                                              Criterion criterion, TransportType... transports);

    /**
     * Метод дает информацию, на каком маршруте находится указанное транспортное средство, и сколько времени оно будет двигаться до последующих остановок.
     *
     * @param hullNo идентификатор транспорта, тот же самый, что в ответах {@link #getFirstArrivalToStop(List, Integer)}, {@link #getFirstArrivalToStop(Integer, Integer)} и других методов.
     */
    void getTransportPosition(String hullNo);

    /**
     * Метод дает информацию о положении транспортов в окрестности пользователя.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     */
    void getSurroundingTransports(GeoPoint geoPoint, Integer radius, Integer count);

    /**
     * Метод дает информацию о положении транспортов на указанных маршрутах.
     *
     * @param krIds классификаторные номера маршрутов.
     * @param count максимальное количество возвращаемых результатов.
     */
    void getTransportsOnRoute(List<Integer> krIds, Integer count);

    /**
     * Метод дает информацию о ближайшех зданиях с адресом в окрестности указанной точки.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     */
    void getNearestBuilding(GeoPoint geoPoint, Integer radius, Integer count);

    /**
     * Метод дает информацию о зданиях по строке с нечетким почтовым адресом.
     * Если заданы координаты пользователя, то результаты упорядочиваются по удаленности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param address  поисковая строчка с адресом.
     * @param count    максимальное количество возвращаемых результатов.
     */
    void findBuildingByAddress(GeoPoint geoPoint, String address, Integer count);

    /**
     * Метод возвращает список пользовательских сообщений в указанной окрестности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус окрестности, по которой собираются события, в метрах.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    void getUserMessages(GeoPoint geoPoint, Integer radius, String deviceId);

    /**
     * Метод отправляет мнение пользователя об указанном сообщении - голос подтверждения или опровержения.
     *
     * @param id       идентификатор сообщения.
     * @param vote     мнение пользователя, одно из значений.
     * @param geoPoint координаты пользователя в WGS 84, чтобы убедиться, что голосующий действительно неподалеку от сообщения.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    void voteForMessage(Integer id, Vote vote, GeoPoint geoPoint, String deviceId);

    /**
     * Метод отправляет геопривязанное пользовательское сообщение.
     *
     * @param text            текст сообщения.
     * @param textEn          текст сообщения на английском (может быть не заполнен).
     * @param link            гиперссылка на более подробный материал.
     * @param geoPoint        координаты центра сообщения в WGS 84.
     * @param radius          радиус окрестности, в которой сообщение стоит показывать, в метрах.
     * @param ksId            классификаторный номер остановки, с которой связано сообщение.
     * @param transportHullNo учетный номер транспортного средства, с которым связано сообщение.
     * @param expireTime      время потери актуальности сообщения в часах.
     * @param deviceId        уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    void sendUserMessage(String text, @Nullable String textEn, String link,
                         GeoPoint geoPoint, Integer radius, Integer ksId,
                         Integer transportHullNo, Integer expireTime, String deviceId);

    @Nullable
    default String doAPIRequest(String message) throws IOException {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("clientId", CLIENT_ID));
        nameValuePairs.add(new BasicNameValuePair("authKey", DigestUtils.sha1Hex(message + KEY)));
        nameValuePairs.add(new BasicNameValuePair("os", "android"));
        nameValuePairs.add(new BasicNameValuePair("message", message));
        Response response = Request.Post(API_URL)
                .bodyForm(nameValuePairs, Charsets.UTF_8)
                .execute();
        HttpResponse httpResponse = response.returnResponse();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == SC_OK) {
            return IOUtils.toString(httpResponse.getEntity().getContent());
        } else {
            LOGGER.error("response code: " + statusCode);
            return null;
        }
    }

}
