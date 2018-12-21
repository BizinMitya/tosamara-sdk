package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GeoPoint implements Serializable {

    @JsonProperty(value = "latitude")
    private Double latitude;

    @JsonProperty(value = "longitude")
    private Double longitude;

    /**
     * Радиус окрестности, в которой сообщение стоит показывать, в метрах.
     */
    @JsonProperty(value = "radius")
    private Integer radius;

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

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

}
