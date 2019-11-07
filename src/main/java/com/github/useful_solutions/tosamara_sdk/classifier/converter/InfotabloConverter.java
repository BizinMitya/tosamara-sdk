package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.util.Optional;

public class InfotabloConverter implements Converter<Boolean> {

    @Override
    public Boolean read(InputNode node) throws Exception {
        String value = node.getValue();
        return Optional.ofNullable(value)
                .map(s -> !s.equals("нет"))
                .orElse(null);
    }

    @Override
    public void write(OutputNode node, Boolean value) {
        Optional.ofNullable(value)
                .ifPresent(b -> node.setValue(b ? "да" : "нет"));
    }

}
