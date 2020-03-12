package com.github.useful_solutions.tosamara_sdk.classifier.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeoPointsDeserializer extends JsonDeserializer<List<GeoPoint>> {

    @Override
    public List<GeoPoint> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        if (value != null) {
            String[] stringPoints = value.split(" ");
            List<GeoPoint> points = new ArrayList<>(stringPoints.length);
            for (String stringPoint : stringPoints) {
                String[] coords = stringPoint.split(",");
                Double latitude = Double.parseDouble(coords[0]);
                Double longitude = Double.parseDouble(coords[1]);
                points.add(new GeoPoint(latitude, longitude));
            }
            return points;
        } else {
            return Collections.emptyList();
        }
    }

}
