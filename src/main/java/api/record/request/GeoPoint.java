package api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPoint {

    @JsonProperty(value = "latitude")
    private Double latitude;

    @JsonProperty(value = "longitude")
    private Double longitude;

    public GeoPoint() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
