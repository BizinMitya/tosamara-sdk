package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class ClassifierWrapper {

    @ElementList(entry = "file", inline = true)
    public List<Classifier> files;

}
