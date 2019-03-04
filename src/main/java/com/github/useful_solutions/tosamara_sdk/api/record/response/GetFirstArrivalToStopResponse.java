package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.ArrivalTransport;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Message;

import java.util.List;

public class GetFirstArrivalToStopResponse {

    @JsonProperty(value = "arrival")
    public List<ArrivalTransport> arrivalTransports;

    public List<Message> messages;

}
