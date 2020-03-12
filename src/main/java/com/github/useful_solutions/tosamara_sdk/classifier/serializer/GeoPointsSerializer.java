package com.github.useful_solutions.tosamara_sdk.classifier.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GeoPointsSerializer extends JsonSerializer<List<GeoPoint>> {

    @Override
    public void serialize(List<GeoPoint> geoPoints, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (geoPoints != null) {
            jsonGenerator.writeString(
                    geoPoints.stream()
                            .map(geoPoint -> geoPoint.latitude + "," + geoPoint.longitude)
                            .collect(Collectors.joining(" "))
            );
        }
    }

}
