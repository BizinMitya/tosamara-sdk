package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.useful_solutions.tosamara_sdk.api.deserializer.TransportTypeDeserializer;

public class Transport {

    /**
     * Классификаторный номер маршрута, на котором сейчас транспорт.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    /**
     * Направление движения транспорта в точке, где он сейчас находится, в градусах от 0 до 360 по тригонометрическому кругу.
     */
    public Double direction;

    /**
     * Флаг доступности для людей с ограниченными возможностями.
     */
    public Boolean forInvalid;

    /**
     * Идентификатор транспорта.
     */
    public Integer hullNo;

    /**
     * Широта, координаты транспорта в WGS 84.
     */
    public Double latitude;

    /**
     * Долгота, координаты транспорта в WGS 84.
     */
    public Double longitude;

    /**
     * Название модели транспорта.
     */
    public String modelTitle;

    /**
     * Классификаторный номер следующей остановки.
     */
    public Integer nextStopId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    public String number;

    /**
     * Автомобильный или парковый номер транспорта.
     */
    public String stateNumber;

    /**
     * Тип транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @JsonDeserialize(using = TransportTypeDeserializer.class)
    public TransportType type;

}
