package com.github.useful_solutions.tosamara_sdk.api;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.*;
import com.github.useful_solutions.tosamara_sdk.api.record.request.FindShortestPathRequest;
import com.github.useful_solutions.tosamara_sdk.api.record.response.*;
import com.github.useful_solutions.tosamara_sdk.exception.APIResponseException;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

/**
 * <a href="https://tosamara.ru/api">https://tosamara.ru/api</a>
 */
public interface APIRequest {

    /**
     * Метод получения прогнозов прибытия транспорта на выбранные остановки.
     * Запрос на несколько остановок сразу, результаты упорядочиваются по времени прибытия.
     *
     * @param ksIds классификаторные номера остановок.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    GetFirstArrivalToStopResponse getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод получения прогнозов прибытия транспорта на выбранную остановку.
     *
     * @param ksId  классификаторный номер остановки.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    GetFirstArrivalToStopResponse getFirstArrivalToStop(Integer ksId, @Nullable Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод получения информации о прибытии транспортных средств выбранного маршрута на выбранную остановку.
     *
     * @param ksId классификаторный номер остановки.
     * @param krId классификаторный номер маршрута.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    GetRouteArrivalToStopResponse getRouteArrivalToStop(Integer ksId, Integer krId)
            throws APIResponseException, IOException;

    /**
     * Метод получения плановых расписаний движения маршрута на текущий день.
     *
     * @param krId классификаторный номер маршрута.
     * @param day  дата, на которую нужно получить расписание, в формате ДД.ММ.ГГГГ.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    GetRouteScheduleResponse getRouteSchedule(Integer krId, String day) throws APIResponseException, IOException;

    /**
     * Метод поиска лучшего маршрута проезда на общественном транспорте.
     *
     * @param geoPoint1  координаты начальной точки маршрута в WGS 84.
     * @param geoPoint2  координаты конечной точки маршрута в WGS 84.
     * @param criterion  критерий оптимальности, одно из значений.
     * @param transports допустимые типы транспорта, набор значений через запятую.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    FindShortestPathResponse findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2,
                                              FindShortestPathRequest.Criterion criterion,
                                              TransportType... transports)
            throws APIResponseException, IOException;

    /**
     * Метод дает информацию, на каком маршруте находится указанное транспортное средство, и сколько времени оно будет двигаться до последующих остановок.
     *
     * @param hullNo идентификатор транспорта, тот же самый, что в ответах
     *               {@link #getFirstArrivalToStop(List, Integer)},
     *               {@link #getFirstArrivalToStop(Integer, Integer)} и других методов.
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    GetTransportPositionResponse getTransportPosition(Integer hullNo) throws APIResponseException, IOException;

    /**
     * Метод дает информацию о положении транспортов в окрестности пользователя.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Transport> getSurroundingTransports(GeoPoint geoPoint, Double radius, Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод дает информацию о положении транспортов на указанных маршрутах.
     *
     * @param krIds классификаторные номера маршрутов.
     * @param count максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Transport> getTransportsOnRoute(List<Integer> krIds, Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод дает информацию о положении транспортов на указанном маршруте.
     *
     * @param krId  классификаторный номер маршрута.
     * @param count максимальное количество возвращаемых результатов.
     * @return список транспорта.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Transport> getTransportsOnRoute(Integer krId, Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод дает информацию о ближайших зданиях с адресом в окрестности указанной точки.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус поиска в метрах.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список зданий.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Building> getNearestBuilding(GeoPoint geoPoint, Double radius, Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод дает информацию о зданиях по строке с нечетким почтовым адресом.
     * Если заданы координаты пользователя, то результаты упорядочиваются по удаленности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param address  поисковая строчка с адресом.
     * @param count    максимальное количество возвращаемых результатов.
     * @return список зданий.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Building> findBuildingByAddress(@Nullable GeoPoint geoPoint, String address, Integer count)
            throws APIResponseException, IOException;

    /**
     * Метод возвращает список пользовательских сообщений в указанной окрестности.
     *
     * @param geoPoint координаты пользователя в WGS 84.
     * @param radius   радиус окрестности, по которой собираются события, в метрах.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     * @return список сообщений.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    List<Message> getUserMessages(GeoPoint geoPoint, Double radius, String deviceId)
            throws APIResponseException, IOException;

    /**
     * Метод отправляет мнение пользователя об указанном сообщении - голос подтверждения или опровержения.
     *
     * @param id       идентификатор сообщения.
     * @param vote     мнение пользователя, одно из значений.
     * @param geoPoint координаты пользователя в WGS 84, чтобы убедиться, что голосующий действительно неподалеку от сообщения.
     * @param deviceId уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     * @return объект ответа.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    VoteForMessageResponse voteForMessage(Integer id, Message.Vote vote, GeoPoint geoPoint, String deviceId)
            throws APIResponseException, IOException;

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
     * @throws IOException          выбрасывается, когда есть несоответствие полей классов и полей JSON или произошла ошибка соединения.
     */
    SendUserMessageResponse sendUserMessage(String text, @Nullable String textEn, String link,
                                            List<Link> links, Integer expireTime, String deviceId)
            throws APIResponseException, IOException;

}
