package api.record.request;

import api.record.Criterion;
import api.record.TransportType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.annotation.Nonnull;

public class FindShortestPathRequest {

    @JsonProperty(value = "method")
    private final String method = "findShortestPath";

    @JsonProperty(value = "LATITUDE1")
    private final double latitude1;

    @JsonProperty(value = "LONGITUDE1")
    private final double longitude1;

    @JsonProperty(value = "LATITUDE2")
    private final double latitude2;

    @JsonProperty(value = "LONGITUDE2")
    private final double longitude2;

    @JsonProperty(value = "CRITERION")
    private final Criterion criterion;

    @JsonProperty(value = "TRANSPORTS")
    private final TransportType[] transports;

    public FindShortestPathRequest(
            @Nonnull GeoPoint firstPoint,
            @Nonnull GeoPoint secondPoint,
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
