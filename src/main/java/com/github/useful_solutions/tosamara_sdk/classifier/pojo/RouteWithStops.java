package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.BitDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.GeoPointsDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.TransportTypeDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.BitSerializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.GeoPointsSerializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.TransportTypeSerializer;

import java.util.List;

public class RouteWithStops {

    /**
     * Классификаторный номер маршрута.
     */
    @JacksonXmlProperty(localName = "KR_ID")
    public Integer krId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @JacksonXmlProperty
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @JacksonXmlProperty
    public String direction;

    @JacksonXmlProperty
    public ExtendedTransportType transportType;

    /**
     * Признак выполняемости маршрута в настоящее время, 1 — да, 0 — нет.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = BitDeserializer.class)
    @JsonSerialize(using = BitSerializer.class)
    public Boolean performing;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = BitDeserializer.class)
    @JsonSerialize(using = BitSerializer.class)
    public Boolean realtimeForecast;

    /**
     * Геометрическая форма маршрута, ломаной линии, заданной последовательностью точек в формате «широта,долгота широта,долгота ...» в системе координат WGS 84.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = GeoPointsDeserializer.class)
    @JsonSerialize(using = GeoPointsSerializer.class)
    public List<GeoPoint> geometry;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "stop")
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
        @JacksonXmlProperty
        public Integer id;

        /**
         * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
         */
        @JacksonXmlProperty
        @JsonDeserialize(using = TransportTypeDeserializer.class)
        @JsonSerialize(using = TransportTypeSerializer.class)
        public TransportType title;

    }

    public static class Stop {

        /**
         * Классификаторный номер остановки.
         */
        @JacksonXmlProperty(localName = "KS_ID")
        public Integer ksId;

        /**
         * Собственное название.
         */
        @JacksonXmlProperty
        public String title;

        /**
         * Улица, на которой расположена остановка.
         */
        @JacksonXmlProperty
        public String adjacentStreet;

        /**
         * Преимущественное направление движения.
         */
        @JacksonXmlProperty
        public String direction;

        /**
         * Плановое время прибытия на остановку от начала выполнения рейса, часто - не заполнено.
         */
        @JacksonXmlProperty
        public Integer scheduleTime;

    }

}
