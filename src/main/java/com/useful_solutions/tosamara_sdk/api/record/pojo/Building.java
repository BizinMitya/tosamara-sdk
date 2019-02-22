package com.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Building {

    /**
     * Расстояние от центра здания до пользователя, в метрах.
     */
    @JsonProperty(value = "distance")
    public Double distance;

    /**
     * Широта центра здания в WGS 84.
     */
    @JsonProperty(value = "latitude")
    public Double latitude;

    /**
     * Долгота центра здания в WGS 84.
     */
    @JsonProperty(value = "longitude")
    public Double longitude;

    /**
     * Краткий адрес здания в формате "улица, дом".
     */
    @JsonProperty(value = "shortAddress")
    public String shortAddress;

    /**
     * Полный адрес здания в формате "город, улица, дом".
     */
    @JsonProperty(value = "fullAddress")
    public String fullAddress;

}
