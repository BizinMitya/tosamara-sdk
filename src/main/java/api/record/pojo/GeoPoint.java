package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public class GeoPoint {

    @JsonProperty(value = "latitude")
    public Double latitude;

    @JsonProperty(value = "longitude")
    public Double longitude;

    public GeoPoint(@NotNull Double latitude, @NotNull Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoPoint() {
    }
}
