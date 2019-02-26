package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FindShortestPathResponse {

    /**
     * Время выполнения маршрута в секундах.
     */
    @JsonProperty(value = "time")
    public Integer time;

    /**
     * Стоимость проезда в рублях.
     */
    @JsonProperty(value = "price")
    public Integer price;

    /**
     * Длина маршрута в метрах.
     */
    @JsonProperty(value = "length")
    public Integer lenght;

    /**
     * Количество поездок (значение более 1 означает, что будут пересадки).
     */
    @JsonProperty(value = "transportTakes")
    public Integer transportTakes;

    @JsonProperty(value = "actions")
    public List<Action> actions;

    public static class Action {

        /**
         * walk - переход пешком.
         * pass - поездка на транспорте.
         */
        @JsonProperty(value = "action")
        public ActionType action;

        /**
         * Длина в метрах.
         */
        @JsonProperty(value = "length")
        public Integer length;

        /**
         * Время выполнения в секундах.
         */
        @JsonProperty(value = "time")
        public Integer time;

        /**
         * Классификаторный номер остановки отправления.
         */
        @JsonProperty(value = "stopFrom")
        public Integer stopFrom;

        /**
         * Классификаторный номер остановки прибытия.
         */
        @JsonProperty(value = "stopTo")
        public Integer stopTo;

        /**
         * Классификаторные номера применяемых маршрутов.
         */
        @JsonProperty(value = "routes")
        public List<Integer> routes;

        /**
         * Текстовое описание действия на русском языке.
         */
        @JsonProperty(value = "comment")
        public String comment;

        /**
         * Геометрическая форма поездки или перехода пешком, ломаной линии,
         * заданной последовательностью точек в формате «широта,долгота широта,долгота ...» в системе координат WGS 84.
         */
        @JsonProperty(value = "geometry")
        public List<GeoPoint> geometry;

        public enum ActionType {

            walk,
            pass

        }

    }
}
