package com.github.useful_solutions.tosamara_sdk.api.record.request;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.GeoPoint;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class FindShortestPathRequest {

    @JsonProperty(value = "method")
    private final String method = "findShortestPath";

    @JsonProperty(value = "LATITUDE1")
    private final Double latitude1;

    @JsonProperty(value = "LONGITUDE1")
    private final Double longitude1;

    @JsonProperty(value = "LATITUDE2")
    private final Double latitude2;

    @JsonProperty(value = "LONGITUDE2")
    private final Double longitude2;

    @JsonProperty(value = "CRITERION")
    private final Criterion criterion;

    @JsonProperty(value = "TRANSPORTS")
    private final TransportType[] transports;

    public FindShortestPathRequest(
            @NotNull GeoPoint firstPoint,
            @NotNull GeoPoint secondPoint,
            Criterion criterion,
            TransportType[] transports
    ) {
        this.longitude1 = firstPoint.longitude;
        this.latitude1 = firstPoint.latitude;
        this.longitude2 = secondPoint.longitude;
        this.latitude2 = secondPoint.latitude;
        this.criterion = criterion;
        this.transports = transports;
    }

    public enum Criterion {

        time,
        price,
        length

    }

    public Double getLatitude1() {
        return latitude1;
    }

    public Double getLongitude1() {
        return longitude1;
    }

    public Double getLatitude2() {
        return latitude2;
    }

    public Double getLongitude2() {
        return longitude2;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public TransportType[] getTransports() {
        return transports;
    }
}
