package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

import java.util.List;

public class FindShortestPathResponse {

    /**
     * Время выполнения маршрута в секундах.
     */
    public Integer time;

    /**
     * Стоимость проезда в рублях.
     */
    public Integer price;

    /**
     * Длина маршрута в метрах.
     */
    public Integer length;

    /**
     * Количество поездок (значение более 1 означает, что будут пересадки).
     */
    public Integer transportTakes;

    public List<Action> actions;

    public static class Action {

        /**
         * walk - переход пешком.
         * pass - поездка на транспорте.
         */
        public ActionType action;

        /**
         * Длина в метрах.
         */
        public Integer length;

        /**
         * Время выполнения в секундах.
         */
        public Integer time;

        /**
         * Классификаторный номер остановки отправления.
         */
        public Integer stopFrom;

        /**
         * Классификаторный номер остановки прибытия.
         */
        public Integer stopTo;

        /**
         * Классификаторные номера применяемых маршрутов.
         */
        public List<Integer> routes;

        /**
         * Текстовое описание действия на русском языке.
         */
        public String comment;

        /**
         * Геометрическая форма поездки или перехода пешком, ломаной линии,
         * заданной последовательностью точек в формате «широта,долгота широта,долгота ...» в системе координат WGS 84.
         */
        public List<GeoPoint> geometry;

        public enum ActionType {

            walk,
            pass

        }

    }
}
