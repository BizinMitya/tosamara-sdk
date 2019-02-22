package com.useful_solutions.tosamara_sdk.classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class InfotabloConverter implements Converter<Boolean> {

    @Override
    public Boolean read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return !value.equals("нет");
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, Boolean value) {
        if (value != null) {
            node.setValue(value ? "да" : "нет");
        }
    }

}
