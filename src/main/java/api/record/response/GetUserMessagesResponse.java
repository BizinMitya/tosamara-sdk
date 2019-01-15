package api.record.response;

import api.record.pojo.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetUserMessagesResponse {

    @JsonProperty(value = "messages")
    public List<Message> messages;

}
