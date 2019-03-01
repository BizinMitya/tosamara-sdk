package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Building {

    /**
     * Расстояние от центра здания до пользователя, в метрах.
     */
    @JsonProperty
    public Double distance;

    /**
     * Широта центра здания в WGS 84.
     */
    @JsonProperty
    public Double latitude;

    /**
     * Долгота центра здания в WGS 84.
     */
    @JsonProperty
    public Double longitude;

    /**
     * Краткий адрес здания в формате "улица, дом".
     */
    @JsonProperty
    public String shortAddress;

    /**
     * Полный адрес здания в формате "город, улица, дом".
     */
    @JsonProperty
    public String fullAddress;

}
