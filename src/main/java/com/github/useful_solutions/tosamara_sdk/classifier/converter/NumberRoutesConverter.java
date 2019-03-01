package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class NumberRoutesConverter implements Converter<List<String>> {

    @Override
    public List<String> read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return Arrays.asList(value
                    .replaceAll("\\s", "")
                    .split(","));
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, List<String> value) {
        if (value != null) {
            StringJoiner stringJoiner = new StringJoiner(", ");
            value.forEach(stringJoiner::add);
            node.setValue(stringJoiner.toString());
        }
    }

}
