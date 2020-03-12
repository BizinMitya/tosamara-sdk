package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RouteOnMap {

    /**
     * Классификаторный номер маршрута.
     */
    @JacksonXmlProperty(localName = "KR_ID")
    public Integer krId;

    /**
     * Идентификатор геопортального объекта маршрута.
     */
    @JacksonXmlProperty
    public Integer geoportalId;

    /**
     * Идентификатор геопортального слоя с маршрутом.
     */
    @JacksonXmlProperty
    public String layerName;

}
