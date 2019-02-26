package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class TransportTypeConverter implements Converter<TransportType> {

    @Override
    public TransportType read(InputNode node) throws Exception {
        String value = node.getValue();
        if (value != null) {
            return TransportType.convert(value);
        } else {
            return null;
        }
    }

    @Override
    public void write(OutputNode node, TransportType value) {
        if (value != null) {
            node.setValue(TransportType.convert(value));
        }
    }

}
