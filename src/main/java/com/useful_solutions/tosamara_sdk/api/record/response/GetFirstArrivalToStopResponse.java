package com.useful_solutions.tosamara_sdk.api.record.response;

import com.useful_solutions.tosamara_sdk.api.record.pojo.ArrivalTransport;
import com.useful_solutions.tosamara_sdk.api.record.pojo.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetFirstArrivalToStopResponse {

    @JsonProperty(value = "arrival")
    public List<ArrivalTransport> arrivalTransports;

    @JsonProperty(value = "messages")
    public List<Message> messages;

}
