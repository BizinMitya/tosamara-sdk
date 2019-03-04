package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import org.jetbrains.annotations.NotNull;

public class GeoPoint {

    public Double latitude;

    public Double longitude;

    public GeoPoint(@NotNull Double latitude, @NotNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoPoint() {
    }
}
