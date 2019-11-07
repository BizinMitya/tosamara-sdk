package com.github.useful_solutions.tosamara_sdk.classifier.converter;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

import java.util.Optional;

public class TransportTypeConverter implements Converter<TransportType> {

    @Override
    public TransportType read(InputNode node) throws Exception {
        String value = node.getValue();
        return Optional.ofNullable(value)
                .map(TransportType::convert)
                .orElse(null);
    }

    @Override
    public void write(OutputNode node, TransportType value) {
        Optional.ofNullable(value)
                .ifPresent(transportType -> node.setValue(TransportType.convert(transportType)));
    }

}
