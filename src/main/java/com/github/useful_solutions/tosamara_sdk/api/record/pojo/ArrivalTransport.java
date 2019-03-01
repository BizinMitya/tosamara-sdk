package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.useful_solutions.tosamara_sdk.api.deserializer.StringToTransportTypeDeserializer;

import java.time.LocalTime;

public class ArrivalTransport {

    /**
     * Тип транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @JsonDeserialize(using = StringToTransportTypeDeserializer.class)
    public TransportType type;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    public String number;

    /**
     * Классификаторный номер маршрута.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    /**
     * Время до прибытия транспорта на остановку.
     */
    @JsonProperty
    public Integer time;

    /**
     * Идентификатор транспорта.
     */
    @JsonProperty
    public Integer hullNo;

    /**
     * Номер госрегистрации.
     */
    @JsonProperty
    public String stateNumber;

    /**
     * Название модели транспорта.
     */
    @JsonProperty
    public String modelTitle;

    /**
     * Флаг доступности для людей с ограниченными возможностями.
     */
    @JsonProperty
    public Boolean forInvalid;

    /**
     * Классификаторный номер остановки, для которой запрошен прогноз (помогает разобраться при запросе на несколько остановок сразу).
     */
    @JsonProperty
    public Integer requestedStopId;

    @JsonProperty
    public Integer nextStopId;

    /**
     * Время до прибытия транспорта на остановку в секундах.
     */
    @JsonProperty
    public Double timeInSeconds;

    /**
     * Название следующей остановки.
     */
    @JsonProperty
    public String nextStopName;

    /**
     * Расстояние между остановками (в метрах).
     */
    @JsonProperty
    public Double spanLength;

    /**
     * Оставшаяся часть пути (в метрах).
     */
    @JsonProperty
    public Double remainingLength;

    /**
     * Признак качества прогноза, варианты значений:
     * realtime - уверенный по мониторингу реального времени,
     * schedule - предсказан на основе расписаний,
     * offroute - транспорт вне планового маршрута,
     * unattached - неуверенно определен маршрут или направление,
     * damaged - транспорт поврежден и может не принимать пассажиров
     */
    @JsonProperty
    public Quality quality;

    /**
     * Время прибытия на остановку в секундах, если бы транспорт не отклонялся от расписания.
     */
    @JsonProperty
    public Double scheduleTimeTo;

    /**
     * Абсолютное время выхода в настоящий рейс (не на эту остановку!) по расписанию в формате "12:37:15".
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime scheduleDepartureTime;

    /**
     * Время, которое транспорт простоит на остановке по расписанию в секундах (часто будет 0, но для электричек не 0).
     */
    @JsonProperty
    public Double delayTime;

    public enum Quality {

        realtime,
        schedule,
        offroute,
        unattached,
        damaged

    }

}
