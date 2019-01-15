package api.record.request;

import api.record.pojo.GeoPoint;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNearestBuildingRequest {

    @JsonProperty(value = "method")
    private final String method = "getNearestBuilding";

    @JsonProperty(value = "LATITUDE")
    private final Double latitude;

    @JsonProperty(value = "LONGITUDE")
    private final Double longitude;

    @JsonProperty(value = "RADIUS")
    private final Integer radius;

    @JsonProperty(value = "COUNT")
    private final Integer count;

    public GetNearestBuildingRequest(GeoPoint geoPoint, Integer radius, Integer count) {
        this.latitude = geoPoint.latitude;
        this.longitude = geoPoint.longitude;
        this.radius = radius;
        this.count = count;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public Integer getCount() {
        return count;
    }
}
