package com.github.useful_solutions.tosamara_sdk.classifier.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;

import java.io.IOException;

public class TransportTypeSerializer extends JsonSerializer<TransportType> {

    @Override
    public void serialize(TransportType transportType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (transportType != null) {
            jsonGenerator.writeString(TransportType.convert(transportType));
        }
    }

}
