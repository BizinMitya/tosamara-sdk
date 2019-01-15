package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class GeoPoint {

    @JsonProperty(value = "latitude")
    public Double latitude;

    @JsonProperty(value = "longitude")
    public Double longitude;

    @JsonProperty(value = "radius")
    public Double radius;

    public GeoPoint(@NotNull Double latitude, @NotNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoPoint(@NotNull Double latitude, @NotNull Double longitude, @NotNull Double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public GeoPoint() {
    }
}
