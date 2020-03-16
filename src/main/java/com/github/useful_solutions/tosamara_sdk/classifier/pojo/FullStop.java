package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.InfotabloDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.NumberRoutesDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.InfotabloSerializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.NumberRoutesSerializer;

import java.util.List;

public class FullStop {

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

    /**
     * Номер остановочного кластера, редко заполнен.
     */
    @JacksonXmlProperty
    public String cluster;

    /**
     * Перечисление маршрутов муниципальных автобусов, проходящих через остановку.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesMunicipal;

    /**
     * Перечисление маршрутов коммерческих автобусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesCommercial;

    /**
     * Перечисление маршрутов пригородных автобусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesPrigorod;

    /**
     * Перечисление маршрутов сезонных (дачных) автобусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesSeason;

    /**
     * Перечисление маршрутов специальных автобусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesSpecial;

    /**
     * Перечисление маршрутов междугородных автобусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> busesIntercity;

    /**
     * Перечисление маршрутов трамваев.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> trams;

    /**
     * Перечисление маршрутов троллейбусов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> trolleybuses;

    /**
     * Перечисление линий метрополитена (на самом деле, линия в Самаре одна).
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> metros;

    /**
     * Перечисление маршрутов электропоездов.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> electricTrains;

    /**
     * Перечисление маршрутов речных переправ.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = NumberRoutesDeserializer.class)
    @JsonSerialize(using = NumberRoutesSerializer.class)
    public List<String> riverTransports;

    /**
     * Признак наличия на остановке информационного табло.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = InfotabloDeserializer.class)
    @JsonSerialize(using = InfotabloSerializer.class)
    public Boolean infotabloExists;

    /**
     * Географическая северная широта остановки, в градусах.
     */
    @JacksonXmlProperty
    public Double latitude;

    /**
     * Географическая восточная долгота остановки, в градусах.
     */
    @JacksonXmlProperty
    public Double longitude;

    @JacksonXmlProperty
    public Integer angle;

}
