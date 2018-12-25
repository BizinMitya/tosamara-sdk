package api.record.request;

import api.record.pojo.Criterion;
import api.record.pojo.GeoPoint;
import api.record.pojo.TransportType;
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
        this.longitude1 = firstPoint.getLongitude();
        this.latitude1 = firstPoint.getLatitude();
        this.longitude2 = secondPoint.getLongitude();
        this.latitude2 = secondPoint.getLatitude();
        this.criterion = criterion;
        this.transports = transports;
    }
}
