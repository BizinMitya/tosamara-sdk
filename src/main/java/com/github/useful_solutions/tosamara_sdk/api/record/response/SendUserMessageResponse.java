package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Status;

import java.time.ZonedDateTime;

public class SendUserMessageResponse {

    /**
     * Идентификатор сообщения.
     */
    public String id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime creationTimestamp;

    /**
     * Признак успешности операции, одно из значений: success, failed, accepted.
     */
    public Status status;

    /**
     * В случае неуспешности содержит описание ошибки.
     */
    public String error;

}
