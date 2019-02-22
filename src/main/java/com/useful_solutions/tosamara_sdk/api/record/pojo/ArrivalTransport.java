package com.useful_solutions.tosamara_sdk.api.record.pojo;

import com.useful_solutions.tosamara_sdk.api.deserializer.StringToTransportTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalTime;

public class ArrivalTransport {

    /**
     * Тип транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @JsonProperty(value = "type")
    @JsonDeserialize(using = StringToTransportTypeDeserializer.class)
    public TransportType type;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @JsonProperty(value = "number")
    public String number;

    /**
     * Классификаторный номер маршрута.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    /**
     * Время до прибытия транспорта на остановку.
     */
    @JsonProperty(value = "time")
    public Integer time;

    /**
     * Идентификатор транспорта.
     */
    @JsonProperty(value = "hullNo")
    public Integer hullNo;

    /**
     * Номер госрегистрации.
     */
    @JsonProperty(value = "stateNumber")
    public String stateNumber;

    /**
     * Название модели транспорта.
     */
    @JsonProperty(value = "modelTitle")
    public String modelTitle;

    /**
     * Флаг доступности для людей с ограниченными возможностями.
     */
    @JsonProperty(value = "forInvalid")
    public Boolean forInvalid;

    /**
     * Классификаторный номер остановки, для которой запрошен прогноз (помогает разобраться при запросе на несколько остановок сразу).
     */
    @JsonProperty(value = "requestedStopId")
    public Integer requestedStopId;

    @JsonProperty(value = "nextStopId")
    public Integer nextStopId;

    /**
     * Время до прибытия транспорта на остановку в секундах.
     */
    @JsonProperty(value = "timeInSeconds")
    public Double timeInSeconds;

    /**
     * Название следующей остановки.
     */
    @JsonProperty(value = "nextStopName")
    public String nextStopName;

    /**
     * Расстояние между остановками (в метрах).
     */
    @JsonProperty(value = "spanLength")
    public Double spanLength;

    /**
     * Оставшаяся часть пути (в метрах).
     */
    @JsonProperty(value = "remainingLength")
    public Double remainingLength;

    /**
     * Признак качества прогноза, варианты значений:
     * realtime - уверенный по мониторингу реального времени,
     * schedule - предсказан на основе расписаний,
     * offroute - транспорт вне планового маршрута,
     * unattached - неуверенно определен маршрут или направление,
     * damaged - транспорт поврежден и может не принимать пассажиров
     */
    @JsonProperty(value = "quality")
    public Quality quality;

    /**
     * Время прибытия на остановку в секундах, если бы транспорт не отклонялся от расписания.
     */
    @JsonProperty(value = "scheduleTimeTo")
    public Double scheduleTimeTo;

    /**
     * Абсолютное время выхода в настоящий рейс (не на эту остановку!) по расписанию в формате "12:37:15".
     */
    @JsonProperty(value = "scheduleDepartureTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime scheduleDepartureTime;

    /**
     * Время, которое транспорт простоит на остановке по расписанию в секундах (часто будет 0, но для электричек не 0).
     */
    @JsonProperty(value = "delayTime")
    public Double delayTime;

    public enum Quality {

        realtime,
        schedule,
        offroute,
        unattached,
        damaged

    }

}
