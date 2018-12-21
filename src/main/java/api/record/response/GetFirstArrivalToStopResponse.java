package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetFirstArrivalToStopResponse {

    @JsonProperty(value = "arrival")
    private List<Transport> transports;

    @JsonProperty(value = "messages")
    private List<Message> messages;

    public GetFirstArrivalToStopResponse() {
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
