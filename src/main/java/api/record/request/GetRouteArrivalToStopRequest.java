package api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRouteArrivalToStopRequest {

    @JsonProperty(value = "method")
    private final String method = "getRouteArrivalToStop";

    @JsonProperty(value = "KS_ID")
    private final Integer ksId;

    @JsonProperty(value = "KR_ID")
    private final Integer krId;

    public GetRouteArrivalToStopRequest(Integer ksId, Integer krId) {
        this.ksId = ksId;
        this.krId = krId;
    }

}
