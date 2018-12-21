package api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPoint {

    @JsonProperty(value = "latitude")
    private Double latitude;

    @JsonProperty(value = "longitude")
    private Double longitude;

    public GeoPoint() {
    }

    public GeoPoint(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

}
