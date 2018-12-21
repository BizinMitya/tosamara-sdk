package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetFirstArrivalToStopResponse {

    @JsonProperty(value = "arrival")
    public List<Transport> transports;

    @JsonProperty(value = "messages")
    public List<Message> messages;

}
