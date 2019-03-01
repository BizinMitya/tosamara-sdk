package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

import java.util.List;

public class FindShortestPathResponse {

    /**
     * Время выполнения маршрута в секундах.
     */
    @JsonProperty
    public Integer time;

    /**
     * Стоимость проезда в рублях.
     */
    @JsonProperty
    public Integer price;

    /**
     * Длина маршрута в метрах.
     */
    @JsonProperty
    public Integer length;

    /**
     * Количество поездок (значение более 1 означает, что будут пересадки).
     */
    @JsonProperty
    public Integer transportTakes;

    @JsonProperty
    public List<Action> actions;

    public static class Action {

        /**
         * walk - переход пешком.
         * pass - поездка на транспорте.
         */
        @JsonProperty
        public ActionType action;

        /**
         * Длина в метрах.
         */
        @JsonProperty
        public Integer length;

        /**
         * Время выполнения в секундах.
         */
        @JsonProperty
        public Integer time;

        /**
         * Классификаторный номер остановки отправления.
         */
        @JsonProperty
        public Integer stopFrom;

        /**
         * Классификаторный номер остановки прибытия.
         */
        @JsonProperty
        public Integer stopTo;

        /**
         * Классификаторные номера применяемых маршрутов.
         */
        @JsonProperty
        public List<Integer> routes;

        /**
         * Текстовое описание действия на русском языке.
         */
        @JsonProperty
        public String comment;

        /**
         * Геометрическая форма поездки или перехода пешком, ломаной линии,
         * заданной последовательностью точек в формате «широта,долгота широта,долгота ...» в системе координат WGS 84.
         */
        @JsonProperty
        public List<GeoPoint> geometry;

        public enum ActionType {

            walk,
            pass

        }

    }
}
