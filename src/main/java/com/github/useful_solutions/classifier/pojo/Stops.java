package com.github.useful_solutions.classifier.pojo;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class Stops {

    @ElementList(entry = "stop", inline = true)
    public List<Stop> stops;

}
