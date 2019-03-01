package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Status;

import java.time.ZonedDateTime;

public class SendUserMessageResponse {

    /**
     * Идентификатор сообщения.
     */
    @JsonProperty
    public String id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime creationTimestamp;

    /**
     * Признак успешности операции, одно из значений: success, failed, accepted.
     */
    @JsonProperty
    public Status status;

    /**
     * В случае неуспешности содержит описание ошибки.
     */
    @JsonProperty
    private String error;

}
