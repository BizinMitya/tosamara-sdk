package com.github.useful_solutions.api.deserializer;

import com.github.useful_solutions.api.record.pojo.TransportType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class StringToTransportTypeDeserializer extends JsonDeserializer<TransportType> {

    @Override
    public TransportType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String text = jsonParser.getText();
        return TransportType.convert(text);
    }

}
