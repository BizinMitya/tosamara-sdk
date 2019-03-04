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
    public Integer time;

    /**
     * Идентификатор транспорта.
     */
    public Integer hullNo;

    /**
     * Номер госрегистрации.
     */
    public String stateNumber;

    /**
     * Название модели транспорта.
     */
    public String modelTitle;

    /**
     * Флаг доступности для людей с ограниченными возможностями.
     */
    public Boolean forInvalid;

    /**
     * Классификаторный номер остановки, для которой запрошен прогноз (помогает разобраться при запросе на несколько остановок сразу).
     */
    public Integer requestedStopId;

    public Integer nextStopId;

    /**
     * Время до прибытия транспорта на остановку в секундах.
     */
    public Double timeInSeconds;

    /**
     * Название следующей остановки.
     */
    public String nextStopName;

    /**
     * Расстояние между остановками (в метрах).
     */
    public Double spanLength;

    /**
     * Оставшаяся часть пути (в метрах).
     */
    public Double remainingLength;

    /**
     * Признак качества прогноза, варианты значений:
     * realtime - уверенный по мониторингу реального времени,
     * schedule - предсказан на основе расписаний,
     * offroute - транспорт вне планового маршрута,
     * unattached - неуверенно определен маршрут или направление,
     * damaged - транспорт поврежден и может не принимать пассажиров
     */
    public Quality quality;

    /**
     * Время прибытия на остановку в секундах, если бы транспорт не отклонялся от расписания.
     */
    public Double scheduleTimeTo;

    /**
     * Абсолютное время выхода в настоящий рейс (не на эту остановку!) по расписанию в формате "12:37:15".
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime scheduleDepartureTime;

    /**
     * Время, которое транспорт простоит на остановке по расписанию в секундах (часто будет 0, но для электричек не 0).
     */
    public Double delayTime;

    public enum Quality {

        realtime,
        schedule,
        offroute,
        unattached,
        damaged

    }

}
