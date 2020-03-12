package com.github.useful_solutions.tosamara_sdk.classifier.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.useful_solutions.tosamara_sdk.classifier.pojo.Affiliation;

import java.io.IOException;

public class AffiliationSerializer extends JsonSerializer<Affiliation> {

    @Override
    public void serialize(Affiliation affiliation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (affiliation != null) {
            jsonGenerator.writeString(Affiliation.convert(affiliation));
        }
    }

}
