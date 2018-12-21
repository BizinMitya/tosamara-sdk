package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoPoint {

    @JsonProperty(value = "latitude")
    public Double latitude;

    @JsonProperty(value = "longitude")
    public Double longitude;

    /**
     * Радиус окрестности, в которой сообщение стоит показывать, в метрах.
     */
    @JsonProperty(value = "radius")
    public Integer radius;

}
