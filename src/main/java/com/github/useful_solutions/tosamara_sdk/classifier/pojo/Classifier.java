package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Classifier {

    @JacksonXmlProperty(isAttribute = true)
    public String name;

    @JacksonXmlProperty
    public Double modified;

}
