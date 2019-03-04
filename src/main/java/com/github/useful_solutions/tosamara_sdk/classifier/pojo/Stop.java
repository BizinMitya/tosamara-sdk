package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Stop {

    @Attribute(required = false)
    public Boolean external;

    /**
     * Классификаторный номер остановки.
     */
    @Element(name = "KS_ID")
    public Integer ksId;

    /**
     * Собственное название.
     */
    @Element(required = false)
    public String title;

    /**
     * Улица, на которой расположена остановка.
     */
    @Element(required = false)
    public String adjacentStreet;

    /**
     * Преимущественное направление движения.
     */
    @Element(required = false)
    public String direction;

    /**
     * Собственное название на английском языке.
     */
    @Element(required = false)
    public String titleEn;

    /**
     * Улица на английском.
     */
    @Element(required = false)
    public String adjacentStreetEn;

    /**
     * Преимущественное направление движения на английском.
     */
    @Element(required = false)
    public String directionEn;

    @Element(required = false)
    public String titleEs;

    @Element(required = false)
    public String adjacentStreetEs;

    @Element(required = false)
    public String directionEs;

}
