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
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime endTime;

    /**
     * Информация о первом маршруте.
     */
    public FirstRace firstRace;

    /**
     * Интервал движения.
     */
    public Integer interval;

    /**
     * Информация о последнем маршруте.
     */
    public LastRace lastRace;

    /**
     * Модели транспортных средств.
     */
    public List<String> models;

    /**
     * Расписание для каждой из остановок.
     */
    @JsonProperty(value = "schedule")
    public List<Schedule> schedules;

    /**
     * Время начала движения.
     */
    @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
    public ZonedDateTime startTime;

    /**
     * Остановки.
     */
    public List<String> stops;

    public static class FirstRace {

        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime time;

        @JsonProperty
        public String controlPoint;

    }

    public static class LastRace {

        public String endControlPoint;

        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime endTime;

        public String startControlPoint;

        @JsonDeserialize(using = StringToZonedDateTimeDeserializer.class)
        public ZonedDateTime startTime;

    }

    public static class Schedule {

        public String stopName;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        public List<LocalTime> time;

    }

}
