package com.github.useful_solutions.tosamara_sdk.classifier.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.List;

public class NumberRoutesSerializer extends JsonSerializer<List<String>> {

    @Override
    public void serialize(List<String> strings, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (strings != null) {
            jsonGenerator.writeString(String.join(", ", strings));
        }
    }

}
