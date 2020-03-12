package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "stops")
public class StopOnMapWrapper {

    /**
     * Идентификатор геопортального слоя с остановками.
     */
    @JacksonXmlProperty
    public String layerName;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "stop")
    public List<StopOnMap> stopsOnMap;

}
