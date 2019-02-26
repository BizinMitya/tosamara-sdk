package com.github.useful_solutions.tosamara_sdk.api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetTransportsOnRouteRequest {

    @JsonProperty(value = "method")
    private final String method = "getTransportsOnRoute";

    @JsonProperty(value = "KR_ID")
    private final List<Integer> krIds;

    @JsonProperty(value = "COUNT")
    private final Integer count;

    public GetTransportsOnRouteRequest(List<Integer> krIds, Integer count) {
        this.krIds = krIds;
        this.count = count;
    }

    public List<Integer> getKrIds() {
        return krIds;
    }

    public Integer getCount() {
        return count;
    }

}
