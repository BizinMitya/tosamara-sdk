package com.github.useful_solutions.tosamara_sdk.api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;

public class GetUserMessagesRequest {

    @JsonProperty
    private final String method = "getUserMessages";

    @JsonProperty(value = "LATITUDE")
    private final Double latitude;

    @JsonProperty(value = "LONGITUDE")
    private final Double longitude;

    @JsonProperty(value = "RADIUS")
    private final Double radius;

    @JsonProperty(value = "DEVICEID")
    private final String deviceId;

    public GetUserMessagesRequest(GeoPoint geoPoint, Double radius, String deviceId) {
        this.latitude = geoPoint.latitude;
        this.longitude = geoPoint.longitude;
        this.radius = radius;
        this.deviceId = deviceId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getRadius() {
        return radius;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
