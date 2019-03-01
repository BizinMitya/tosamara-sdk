package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public class Message {

    /**
     * Идентификатор сообщения.
     */
    public Integer id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime creationTimestamp;

    /**
     * Дата и время потери актуальности сообщения.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public ZonedDateTime expireTimestamp;

    /**
     * Текст сообщения.
     */
    public String text;

    /**
     * Текст сообщения на английском (может быть не заполнен).
     */
    public String textEn;

    public String textEs;

    /**
     * Гиперссылка на более подробный материал.
     */
    public String link;

    /**
     * Геопривязка сообщения, возможно, множественная.
     */
    @JsonProperty(value = "linking")
    public List<Link> links;

    /**
     * Уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    public String authorDeviceId;

    /**
     * Статус важности источника, одно из значений: passenger, massmedia, official.
     */
    public AuthorStatus authorStatus;

    /**
     * Количество голосов подтверждения.
     */
    public Integer confirms;

    /**
     * Количество голосов опровержения.
     */
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
