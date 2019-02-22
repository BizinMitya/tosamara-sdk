package com.useful_solutions.tosamara_sdk.api.deserializer;

import com.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
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
