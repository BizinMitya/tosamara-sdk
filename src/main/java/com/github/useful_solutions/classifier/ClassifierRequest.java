package com.github.useful_solutions.classifier;

import com.github.useful_solutions.classifier.pojo.*;

import java.util.List;

public interface ClassifierRequest {

    /**
     * Метод получения списка справочников.
     *
     * @return список справочников.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Classifier> getClassifiers() throws Exception;

    /**
     * Метод получения списка остановок.
     *
     * @return список остановок.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Stop> getStops() throws Exception;

    /**
     * Метод получения списка остановок с расширенной информацией.
     *
     * @return список остановок с расширенной информацией.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<FullStop> getFullStops() throws Exception;

    /**
     * Метод получения списка маршрутов.
     *
     * @return список маршрутов.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<Route> getRoutes() throws Exception;

    /**
     * Метод получения списка связей маршрутов и остановок.
     *
     * @return список связей маршрутов и остановок.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<RouteWithStops> getRoutesWithStops() throws Exception;

    /**
     * Метод получения остановок на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     *
     * @return список остановок на карте геопортала.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    StopsOnMap getStopsOnMap() throws Exception;

    /**
     * Метод получения маршрутов на карте {@see <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>}
     * Связывает маршруты со слоями и объектами на карте.
     * В каждом слое обыкновенно находятся два линейных объекта - прямое и обратное направление одного маршрута, и несколько объектов транспорта, которые движутся в реальном времени.
     *
     * @return список маршрутов на карте геопортала.
     * @throws Exception выбрасывается в случае ошибок десериализации, ошибок соединения или если код ответа не равен 200.
     */
    List<RouteOnMap> getRoutesOnMap() throws Exception;

}
