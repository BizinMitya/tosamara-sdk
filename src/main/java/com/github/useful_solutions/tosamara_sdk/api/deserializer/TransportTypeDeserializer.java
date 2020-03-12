package com.github.useful_solutions.tosamara_sdk.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;

import java.io.IOException;

public class TransportTypeDeserializer extends JsonDeserializer<TransportType> {

    @Override
    public TransportType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String text = jsonParser.getText();
        return TransportType.convert(text);
    }

}
