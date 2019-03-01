package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Status;

public class VoteForMessageResponse {

    /**
     * Признак успешности операции, одно из значений: success, failed.
     */
    @JsonProperty
    public Status status;

    /**
     * В случае неуспешности содержит описание ошибки.
     */
    @JsonProperty
    public String text;

}
