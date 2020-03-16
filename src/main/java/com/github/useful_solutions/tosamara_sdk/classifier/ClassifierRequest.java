package com.github.useful_solutions.tosamara_sdk.classifier;

import com.github.useful_solutions.tosamara_sdk.classifier.pojo.*;
import com.github.useful_solutions.tosamara_sdk.exception.APIResponseException;

import java.io.IOException;
import java.util.List;

/**
 * <a href="https://tosamara.ru/api">https://tosamara.ru/api</a>
 */
public interface ClassifierRequest {

    /**
     * Метод получения списка справочников.
     *
     * @return список справочников.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<Classifier> getClassifiers() throws APIResponseException, IOException;

    /**
     * Метод получения всех справочников.
     *
     * @return объект, содержащий все справочники.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    AllClassifiers getAllClassifiers() throws APIResponseException, IOException;

    /**
     * Метод получения списка остановок.
     *
     * @return список остановок.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<Stop> getStops() throws APIResponseException, IOException;

    /**
     * Метод получения списка остановок с расширенной информацией.
     *
     * @return список остановок с расширенной информацией.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<FullStop> getFullStops() throws APIResponseException, IOException;

    /**
     * Метод получения списка маршрутов.
     *
     * @return список маршрутов.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<Route> getRoutes() throws APIResponseException, IOException;

    /**
     * Метод получения списка связей маршрутов и остановок.
     *
     * @return список связей маршрутов и остановок.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<RouteWithStops> getRoutesWithStops() throws APIResponseException, IOException;

    /**
     * Метод получения остановок на карте <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>
     *
     * @return список остановок на карте геопортала.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    StopOnMapWrapper getStopsOnMap() throws APIResponseException, IOException;

    /**
     * Метод получения маршрутов на карте <a href="https://map.samadm.ru/transport/">Муниципального геопортала Самары</a>
     * Связывает маршруты со слоями и объектами на карте.
     * В каждом слое обыкновенно находятся два линейных объекта - прямое и обратное направление одного маршрута, и несколько объектов транспорта, которые движутся в реальном времени.
     *
     * @return список маршрутов на карте геопортала.
     * @throws IOException          выбрасывается в случае ошибок десериализации или ошибок соединения.
     * @throws APIResponseException выбрасывается, если код ответа не равен 200.
     */
    List<RouteOnMap> getRoutesOnMap() throws APIResponseException, IOException;

}
