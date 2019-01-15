package api.record.request;

import api.record.pojo.GeoPoint;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserMessagesRequest {

    @JsonProperty(value = "method")
    private final String method = "getUserMessages";

    @JsonProperty(value = "LATITUDE")
    private final Double latitude;

    @JsonProperty(value = "LONGITUDE")
    private final Double longitude;

    @JsonProperty(value = "RADIUS")
    private final Integer radius;

    @JsonProperty(value = "DEVICEID")
    private final String deviceId;

    public GetUserMessagesRequest(GeoPoint geoPoint, Integer radius, String deviceId) {
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

    public Integer getRadius() {
        return radius;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
