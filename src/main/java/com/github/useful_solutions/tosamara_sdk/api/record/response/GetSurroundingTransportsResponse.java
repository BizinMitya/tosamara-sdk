package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Transport;

import java.util.List;

public class GetSurroundingTransportsResponse {

    @JsonProperty
    public List<Transport> transports;

}
