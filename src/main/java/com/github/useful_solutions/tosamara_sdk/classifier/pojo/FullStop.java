package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.github.useful_solutions.tosamara_sdk.classifier.converter.InfotabloConverter;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.NumberRoutesConverter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;

import java.util.List;

public class FullStop {

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

    /**
     * Номер остановочного кластера, редко заполнен.
     */
    @Element(required = false)
    public String cluster;

    /**
     * Перечисление маршрутов муниципальных автобусов, проходящих через остановку.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesMunicipal;

    /**
     * Перечисление маршрутов коммерческих автобусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesCommercial;

    /**
     * Перечисление маршрутов пригородных автобусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesPrigorod;

    /**
     * Перечисление маршрутов сезонных (дачных) автобусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesSeason;

    /**
     * Перечисление маршрутов специальных автобусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesSpecial;

    /**
     * Перечисление маршрутов междугородных автобусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesIntercity;

    /**
     * Перечисление маршрутов трамваев.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> trams;

    /**
     * Перечисление маршрутов троллейбусов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> trolleybuses;

    /**
     * Перечисление линий метрополитена (на самом деле, линия в Самаре одна).
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> metros;

    /**
     * Перечисление маршрутов электропоездов.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> electricTrains;

    /**
     * Перечисление маршрутов речных переправ.
     */
    @Element(required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> riverTransports;

    /**
     * Признак наличия на остановке информационного табло.
     */
    @Element
    @Convert(InfotabloConverter.class)
    public Boolean infotabloExists;

    /**
     * Географическая северная широта остановки, в градусах.
     */
    @Element
    public Double latitude;

    /**
     * Географическая восточная долгота остановки, в градусах.
     */
    @Element
    public Double longitude;

    @Element(required = false)
    public Integer angle;

}
