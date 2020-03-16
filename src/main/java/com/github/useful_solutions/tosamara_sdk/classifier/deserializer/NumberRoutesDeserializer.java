package com.github.useful_solutions.tosamara_sdk.classifier.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberRoutesDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        if (value != null && !value.isEmpty()) {
            return Arrays.asList(value
                    .replaceAll("\\s", "")
                    .split(","));
        } else {
            return Collections.emptyList();
        }
    }

}
