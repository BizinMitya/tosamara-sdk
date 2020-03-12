package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StopOnMap {

    /**
     * Классификаторный номер остановки.
     */
    @JacksonXmlProperty(localName = "KS_ID")
    public Integer ksId;

    /**
     * Идентификатор геопортального объекта остановки.
     */
    @JacksonXmlProperty
    public Integer geoportalId;

    /**
     * Постоянная часть описания геопортального объекта.
     */
    @JacksonXmlCData
    public String staticDescription;

}
