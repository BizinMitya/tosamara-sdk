package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class StopOnMapWrapper {

    /**
     * Идентификатор геопортального слоя с остановками.
     */
    @Element
    public String layerName;

    @ElementList(entry = "stop", inline = true)
    public List<StopOnMap> stopsOnMap;

}
