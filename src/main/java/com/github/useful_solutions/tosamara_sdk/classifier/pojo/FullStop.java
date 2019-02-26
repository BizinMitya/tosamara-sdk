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

    /**
     * Номер остановочного кластера, редко заполнен.
     */
    @Element(name = "cluster", required = false)
    public String cluster;

    /**
     * Перечисление маршрутов муниципальных автобусов, проходящих через остановку.
     */
    @Element(name = "busesMunicipal", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesMunicipal;

    /**
     * Перечисление маршрутов коммерческих автобусов.
     */
    @Element(name = "busesCommercial", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesCommercial;

    /**
     * Перечисление маршрутов пригородных автобусов.
     */
    @Element(name = "busesPrigorod", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesPrigorod;

    /**
     * Перечисление маршрутов сезонных (дачных) автобусов.
     */
    @Element(name = "busesSeason", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesSeason;

    /**
     * Перечисление маршрутов специальных автобусов.
     */
    @Element(name = "busesSpecial", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesSpecial;

    /**
     * Перечисление маршрутов междугородных автобусов.
     */
    @Element(name = "busesIntercity", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> busesIntercity;

    /**
     * Перечисление маршрутов трамваев.
     */
    @Element(name = "trams", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> trams;

    /**
     * Перечисление маршрутов троллейбусов.
     */
    @Element(name = "trolleybuses", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> trolleybuses;

    /**
     * Перечисление линий метрополитена (на самом деле, линия в Самаре одна).
     */
    @Element(name = "metros", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> metros;

    /**
     * Перечисление маршрутов электропоездов.
     */
    @Element(name = "electricTrains", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> electricTrains;

    /**
     * Перечисление маршрутов речных переправ.
     */
    @Element(name = "riverTransports", required = false)
    @Convert(NumberRoutesConverter.class)
    public List<String> riverTransports;

    /**
     * Признак наличия на остановке информационного табло.
     */
    @Element(name = "infotabloExists")
    @Convert(InfotabloConverter.class)
    public Boolean infotabloExists;

    /**
     * Географическая северная широта остановки, в градусах.
     */
    @Element(name = "latitude")
    public Double latitude;

    /**
     * Географическая восточная долгота остановки, в градусах.
     */
    @Element(name = "longitude")
    public Double longitude;

    @Element(name = "angle", required = false)
    public Integer angle;

}
