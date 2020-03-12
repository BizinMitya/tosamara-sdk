package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Stop {

    /**
     * Признак, что остановка находится не в г. Самара, а в другом городе области.
     */
    @JacksonXmlProperty(isAttribute = true)
    public Boolean external;

    /**
     * Классификаторный номер остановки.
     */
    @JacksonXmlProperty(localName = "KS_ID")
    public Integer ksId;

    /**
     * Собственное название.
     */
    @JacksonXmlProperty
    public String title;

    /**
     * Улица, на которой расположена остановка.
     */
    @JacksonXmlProperty
    public String adjacentStreet;

    /**
     * Преимущественное направление движения.
     */
    @JacksonXmlProperty
    public String direction;

    /**
     * Собственное название на английском языке.
     */
    @JacksonXmlProperty
    public String titleEn;

    /**
     * Улица на английском.
     */
    @JacksonXmlProperty
    public String adjacentStreetEn;

    /**
     * Преимущественное направление движения на английском.
     */
    @JacksonXmlProperty
    public String directionEn;

    @JacksonXmlProperty
    public String titleEs;

    @JacksonXmlProperty
    public String adjacentStreetEs;

    @JacksonXmlProperty
    public String directionEs;

}
