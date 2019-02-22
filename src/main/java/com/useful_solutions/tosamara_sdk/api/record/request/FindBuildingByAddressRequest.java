package com.useful_solutions.tosamara_sdk.api.record.request;

import com.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

public class FindBuildingByAddressRequest {

    @JsonProperty(value = "method")
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
        if (geoPoint != null) {
            this.latitude = geoPoint.latitude;
            this.longitude = geoPoint.longitude;
        } else {
            this.latitude = null;
            this.longitude = null;
        }
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
