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
    @Element(name = "title", required = false)
    public String title;

    /**
     * Улица, на которой расположена остановка.
     */
    @Element(name = "adjacentStreet", required = false)
    public String adjacentStreet;

    /**
     * Преимущественное направление движения.
     */
    @Element(name = "direction", required = false)
    public String direction;

    /**
     * Собственное название на английском языке.
     */
    @Element(name = "titleEn", required = false)
    public String titleEn;

    /**
     * Улица на английском.
     */
    @Element(name = "adjacentStreetEn", required = false)
    public String adjacentStreetEn;

    /**
     * Преимущественное направление движения на английском.
     */
    @Element(name = "directionEn", required = false)
    public String directionEn;

    @Element(name = "titleEs", required = false)
    public String titleEs;

    @Element(name = "adjacentStreetEs", required = false)
    public String adjacentStreetEs;

    @Element(name = "directionEs", required = false)
    public String directionEs;

}
