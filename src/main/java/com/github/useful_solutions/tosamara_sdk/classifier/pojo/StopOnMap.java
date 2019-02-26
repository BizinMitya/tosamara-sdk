package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Element;

public class StopOnMap {

    /**
     * Классификаторный номер остановки.
     */
    @Element(name = "KS_ID")
    public Integer ksId;

    /**
     * Идентификатор геопортального объекта остановки.
     */
    @Element(name = "geoportalId")
    public Integer geoportalId;

    /**
     * Постоянная часть описания геопортального объекта.
     */
    @Element(name = "staticDescription", data = true)
    public String staticDescription;

}
