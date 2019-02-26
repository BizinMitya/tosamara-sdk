package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class BooleanConverter implements Converter<Boolean> {

    @Override
    public Boolean read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return value.equals("1");
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, Boolean value) {
        if (value != null) {
            node.setValue(value ? "1" : "0");
        }
    }

}
