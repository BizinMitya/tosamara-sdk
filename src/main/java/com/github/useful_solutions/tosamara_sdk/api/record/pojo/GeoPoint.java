package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class GeoPoint {

    @JsonProperty
    public Double latitude;

    @JsonProperty
    public Double longitude;

    public GeoPoint(@NotNull Double latitude, @NotNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoPoint() {
    }
}
