package com.github.useful_solutions.tosamara_sdk.classifier.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.Affiliation;

import java.io.IOException;
import java.util.Optional;

public class AffiliationDeserializer extends JsonDeserializer<Affiliation> {

    @Override
    public Affiliation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        return Optional.ofNullable(value)
                .map(Affiliation::convert)
                .orElse(null);
    }

}
