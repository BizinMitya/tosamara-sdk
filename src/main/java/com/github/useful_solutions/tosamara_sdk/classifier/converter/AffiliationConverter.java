package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import com.github.useful_solutions.tosamara_sdk.classifier.pojo.Affiliation;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.util.Optional;

public class AffiliationConverter implements Converter<Affiliation> {

    @Override
    public Affiliation read(InputNode node) throws Exception {
        String value = node.getValue();
        return Optional.ofNullable(value)
                .map(Affiliation::convert)
                .orElse(null);
    }

    @Override
    public void write(OutputNode node, Affiliation value) {
        Optional.ofNullable(value)
                .ifPresent(affiliation -> node.setValue(Affiliation.convert(affiliation)));
    }

}
