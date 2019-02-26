package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import com.github.useful_solutions.tosamara_sdk.classifier.pojo.Affiliation;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class AffiliationConverter implements Converter<Affiliation> {

    @Override
    public Affiliation read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return Affiliation.convert(value);
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, Affiliation value) {
        if (value != null) {
            node.setValue(Affiliation.convert(value));
        }
    }

}
