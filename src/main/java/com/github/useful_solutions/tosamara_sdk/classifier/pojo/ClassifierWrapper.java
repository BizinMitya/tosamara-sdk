package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "classifiers")
public class ClassifierWrapper {

    @ElementList(entry = "file", inline = true)
    public List<Classifier> files;

}
