package com.github.useful_solutions.tosamara_sdk.api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import org.jetbrains.annotations.Nullable;

public class FindBuildingByAddressRequest {

    @JsonProperty
    private final String method = "findBuildingByAddress";

    @JsonProperty(value = "LATITUDE")
    private final Double latitude;

    @JsonProperty(value = "LONGITUDE")
    private final Double longitude;

    @JsonProperty(value = "ADDRESS")
    private final String address;

    @JsonProperty(value = "COUNT")
    private final Integer count;

    public FindBuildingByAddressRequest(@Nullable GeoPoint geoPoint, String address, Integer count) {
        this.latitude = geoPoint != null ? geoPoint.latitude : null;
        this.longitude = geoPoint != null ? geoPoint.longitude : null;
        this.address = address;
        this.count = count;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCount() {
        return count;
    }
}
