package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.useful_solutions.tosamara_sdk.api.deserializer.StringToZonedDateTimeDeserializer;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

public class GetRouteScheduleResponse {

    @JsonProperty(value = "KR_ID")
    public Integer krId;

    /**
     * Время окончания движения.
     */
    @JsonProperty
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime endTime;

    /**
     * Информация о первом маршруте.
     */
    @JsonProperty
    public FirstRace firstRace;

    /**
     * Интервал движения.
     */
    @JsonProperty
    public Integer interval;

    /**
     * Информация о последнем маршруте.
     */
    @JsonProperty
    public LastRace lastRace;

    /**
     * Модели транспортных средств.
     */
    @JsonProperty
    public List<String> models;

    /**
     * Расписание для каждой из остановок.
     */
    @JsonProperty(value = "schedule")
    public List<Schedule> schedules;

    /**
     * Время начала движения.
     */
    @JsonProperty
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime startTime;

    /**
     * Остановки.
     */
    @JsonProperty
    public List<String> stops;

    public static class FirstRace {

        @JsonProperty
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime time;

        @JsonProperty
        private String controlPoint;

    }

    public static class LastRace {

        @JsonProperty
        public String endControlPoint;

        @JsonProperty
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime endTime;

        @JsonProperty
        public String startControlPoint;

        @JsonProperty
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime startTime;

    }

    public static class Schedule {

        @JsonProperty
        public String stopName;

        @JsonProperty
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        public List<LocalTime> time;

    }

}
