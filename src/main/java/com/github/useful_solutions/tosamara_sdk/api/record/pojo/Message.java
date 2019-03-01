package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public class Message {

    /**
     * Идентификатор сообщения.
     */
    @JsonProperty
    public Integer id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime creationTimestamp;

    /**
     * Дата и время потери актуальности сообщения.
     */
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime expireTimestamp;

    /**
     * Текст сообщения.
     */
    @JsonProperty
    public String text;

    /**
     * Текст сообщения на английском (может быть не заполнен).
     */
    @JsonProperty
    public String textEn;

    @JsonProperty
    public String textEs;

    /**
     * Гиперссылка на более подробный материал.
     */
    @JsonProperty
    public String link;

    /**
     * Геопривязка сообщения, возможно, множественная.
     */
    @JsonProperty(value = "linking")
    public List<Link> links;

    /**
     * Уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    @JsonProperty
    public String authorDeviceId;

    /**
     * Статус важности источника, одно из значений: passenger, massmedia, official.
     */
    @JsonProperty
    public AuthorStatus authorStatus;

    /**
     * Количество голосов подтверждения.
     */
    @JsonProperty
    public Integer confirms;

    /**
     * Количество голосов опровержения.
     */
    @JsonProperty
    public Integer refutes;

    /**
     * Классификаторный номер остановки, с которой связано сообщение.
     */
    @JsonProperty(value = "KS_ID")
    public Integer ksId;

    /**
     * Учетный номер транспортного средства, с которым связано сообщение.
     */
    @JsonProperty(value = "transportHullno")
    public Integer transportHullNo;

    /**
     * Голос, отданный за данное сообщение самим запрашивающим пользователем, одно из значений: confirm, refute.
     */
    @JsonProperty
    public Vote selfVote;

    public enum AuthorStatus {

        passenger,
        massmedia,
        official,
        none

    }

    public enum Vote {

        confirm,
        refute

    }

}
