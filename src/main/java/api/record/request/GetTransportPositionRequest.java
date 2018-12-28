package api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTransportPositionRequest {

    @JsonProperty(value = "method")
    private final String method = "getTransportPosition";

    /**
     * Идентификатор транспорта.
     */
    @JsonProperty(value = "HULLNO")
    private final Integer hullNo;

    public GetTransportPositionRequest(Integer hullNo) {
        this.hullNo = hullNo;
    }

    public Integer getHullNo() {
        return hullNo;
    }

}
