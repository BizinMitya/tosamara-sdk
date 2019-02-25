package com.github.useful_solutions.api.record.response;

import com.github.useful_solutions.api.deserializer.StringToZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

public class GetRouteScheduleResponse {

    @JsonProperty(value = "KR_ID")
    public Integer krId;

    /**
     * Время окончания движения.
     */
    @JsonProperty(value = "endTime")
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime endTime;

    /**
     * Информация о первом маршруте.
     */
    @JsonProperty(value = "firstRace")
    public FirstRace firstRace;

    /**
     * Интервал движения.
     */
    @JsonProperty(value = "interval")
    public Integer interval;

    /**
     * Информация о последнем маршруте.
     */
    @JsonProperty(value = "lastRace")
    public LastRace lastRace;

    /**
     * Модели транспортных средств.
     */
    @JsonProperty(value = "models")
    public List<String> models;

    /**
     * Расписание для каждой из остановок.
     */
    @JsonProperty(value = "schedule")
    public List<Schedule> schedules;

    /**
     * Время начала движения.
     */
    @JsonProperty(value = "startTime")
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime startTime;

    /**
     * Остановки.
     */
    @JsonProperty(value = "stops")
    public List<String> stops;

    public static class FirstRace {

        @JsonProperty(value = "time")
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime time;

        @JsonProperty(value = "controlPoint")
        private String controlPoint;

    }

    public static class LastRace {

        @JsonProperty(value = "endControlPoint")
        public String endControlPoint;

        @JsonProperty(value = "endTime")
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime endTime;

        @JsonProperty(value = "startControlPoint")
        public String startControlPoint;

        @JsonProperty(value = "startTime")
        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime startTime;

    }

    public static class Schedule {

        @JsonProperty(value = "stopName")
        public String stopName;

        @JsonProperty(value = "time")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        public List<LocalTime> time;

    }

}
