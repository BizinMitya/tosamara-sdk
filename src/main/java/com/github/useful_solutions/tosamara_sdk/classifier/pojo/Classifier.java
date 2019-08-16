package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Classifier {

    @Attribute
    public String name;

    @Element
    public Double modified;

}
