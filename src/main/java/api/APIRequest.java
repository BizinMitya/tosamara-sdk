package api;

import api.record.Criterion;
import api.record.GeoPoint;
import api.record.Transports;
import api.record.Vote;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * http://www.tosamara.ru/api/
 */
public interface APIRequest {

    /**
     * Метод получения прогнозов прибытия транспорта на выбранную остановку.
     * Возможен запрос на несколько остановок сразу, в таком случае результаты упорядочиваются по времени прибытия.
     *
     * @param ksIds классификаторные номера остановок.
     * @param count количество ближайших прибывающих маршрутов (необязательный параметр).
     */
    void getFirstArrivalToStop(List<Integer> ksIds, @Nullable Integer count);

    /**
     * Метод получения информации о прибытии транспортных средств выбранного маршрута на выбранную остановку.
     *
     * @param ksId классификаторный номер остановки.
     * @param krId классификаторный номер маршрута.
     */
    void getRouteArrivalToStop(Integer ksId, Integer krId);

    /**
     * Метод получения плановых расписаний движения маршрута на текущий день.
     *
     * @param krId классификаторный номер маршрута.
     * @param day  дата, на которую нужно получить расписание, в формате ДД.ММ.ГГГГ.
     */
    void getRouteSchedule(Integer krId, String day);

    /**
     * Метод поиска лучшего маршрута проезда на общественном транспорте.
     *
     * @param geoPoint1  координаты начальной точки маршрута в WGS 84.
     * @param geoPoint2  координаты конечной точки маршрута в WGS 84.
     * @param transports допустимые типы транспорта, набор значений через запятую.
     * @param criterion  критерий оптимальности, одно из значений.
     */
    void findShortestPath(GeoPoint geoPoint1, GeoPoint geoPoint2, List<Transports> transports, Criterion criterion);

    /**
     * Метод дает информацию, на каком маршруте находится указанное транспортное средство, и сколько времени оно будет двигаться до последующих остановок.
     *
     * @param hullNo идентификатор транспорта, тот же самый, что в ответах {@link #getFirstArrivalToStop(List, Integer)} и других методов.
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
    void sendUserMessage(String text, @Nullable String textEn, String link, GeoPoint geoPoint,
                         Integer radius, Integer ksId, Integer transportHullNo, Integer expireTime, String deviceId);

}
