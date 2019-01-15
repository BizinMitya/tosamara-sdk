package api.record.response;

import api.record.pojo.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteForMessageResponse {

    /**
     * Признак успешности операции, одно из значений: success, failed.
     */
    @JsonProperty(value = "status")
    public Status status;

    /**
     * В случае неуспешности содержит описание ошибки.
     */
    @JsonProperty(value = "text")
    public String text;

}
