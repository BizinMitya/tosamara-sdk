package api.record.response;

import api.record.pojo.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SendUserMessageResponse {

    /**
     * Идентификатор сообщения.
     */
    @JsonProperty(value = "id")
    public String id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonProperty(value = "creationTimestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public Date creationTimestamp;

    /**
     * Признак успешности операции, одно из значений: success, failed, accepted.
     */
    @JsonProperty(value = "status")
    public Status status;

    /**
     * В случае неуспешности содержит описание ошибки.
     */
    @JsonProperty(value = "error")
    private String error;

}
