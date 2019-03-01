package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

public class Building {

    /**
     * Расстояние от центра здания до пользователя, в метрах.
     */
    public Double distance;

    /**
     * Широта центра здания в WGS 84.
     */
    public Double latitude;

    /**
     * Долгота центра здания в WGS 84.
     */
    public Double longitude;

    /**
     * Краткий адрес здания в формате "улица, дом".
     */
    public String shortAddress;

    /**
     * Полный адрес здания в формате "город, улица, дом".
     */
    public String fullAddress;

}
