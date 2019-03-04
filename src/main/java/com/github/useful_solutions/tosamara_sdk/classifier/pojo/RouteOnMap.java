package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Element;

public class RouteOnMap {

    /**
     * Классификаторный номер маршрута.
     */
    @Element(name = "KR_ID")
    public Integer krId;

    /**
     * Идентификатор геопортального объекта маршрута.
     */
    @Element
    public Integer geoportalId;

    /**
     * Идентификатор геопортального слоя с маршрутом.
     */
    @Element
    public String layerName;

}
