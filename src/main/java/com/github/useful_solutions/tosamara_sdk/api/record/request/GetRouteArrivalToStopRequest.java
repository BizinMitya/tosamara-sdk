package com.github.useful_solutions.tosamara_sdk.api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetRouteArrivalToStopRequest {

    @JsonProperty
    private final String method = "getRouteArrivalToStop";

    @JsonProperty(value = "KS_ID")
    private final Integer ksId;

    @JsonProperty(value = "KR_ID")
    private final Integer krId;

    public GetRouteArrivalToStopRequest(Integer ksId, Integer krId) {
        this.ksId = ksId;
        this.krId = krId;
    }

    public Integer getKsId() {
        return ksId;
    }

    public Integer getKrId() {
        return krId;
    }

}
