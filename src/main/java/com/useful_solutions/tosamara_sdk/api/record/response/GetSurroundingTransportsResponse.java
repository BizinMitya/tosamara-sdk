package com.useful_solutions.tosamara_sdk.api.record.response;

import com.useful_solutions.tosamara_sdk.api.record.pojo.Transport;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetSurroundingTransportsResponse {

    @JsonProperty(value = "transports")
    public List<Transport> transports;

}
