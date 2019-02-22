package com.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "file")
public class Classifier {

    @Attribute
    public String name;

    @Element
    public Double modified;

}
