package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.BitConverter;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.GeoPointsConverter;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.TransportTypeConverter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.convert.Convert;

import java.util.List;

public class RouteWithStops {

    /**
     * Классификаторный номер маршрута.
     */
    @Element(name = "KR_ID")
    public Integer krId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @Element
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @Element
    public String direction;

    @Element
    public ExtendedTransportType transportType;

    /**
     * Признак выполняемости маршрута в настоящее время, 1 — да, 0 — нет.
     */
    @Element
    @Convert(BitConverter.class)
    public Boolean performing;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @Element
    @Convert(BitConverter.class)
    public Boolean realtimeForecast;

    /**
     * Геометрическая форма маршрута, ломаной линии, заданной последовательностью точек в формате «широта,долгота широта,долгота ...» в системе координат WGS 84.
     */
    @Element
    @Convert(GeoPointsConverter.class)
    public List<GeoPoint> geometry;

    @ElementList(entry = "stop", inline = true)
    public List<Stop> stops;

    public static class ExtendedTransportType {

        /**
         * Числовой код вида транспорта:
         * 1 — автобус,
         * 2 — метрополитен,
         * 3 — трамвай,
         * 4 — троллейбус,
         * 5 - электропоезд,
         * 6 - речной транспорт
         */
        @Element
        public Integer id;

        /**
         * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
         */
        @Element
        @Convert(TransportTypeConverter.class)
        public TransportType title;

    }

    public static class Stop {

        /**
         * Классификаторный номер остановки.
         */
        @Element(name = "KS_ID")
        public Integer ksId;

        /**
         * Собственное название.
         */
        @Element
        public String title;

        /**
         * Улица, на которой расположена остановка.
         */
        @Element
        public String adjacentStreet;

        /**
         * Преимущественное направление движения.
         */
        @Element(required = false)
        public String direction;

        /**
         * Плановое время прибытия на остановку от начала выполнения рейса, часто - не заполнено.
         */
        @Element
        public Integer scheduleTime;

    }

}
