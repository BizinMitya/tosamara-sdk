package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Message {

    /**
     * Идентификатор сообщения.
     */
    @JsonProperty(value = "id")
    public Integer id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonProperty(value = "creationTimestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public Date creationTimestamp;

    /**
     * Дата и время потери актуальности сообщения.
     */
    @JsonProperty(value = "expireTimestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", timezone = "Europe/Samara")
    public Date expireTimestamp;

    /**
     * Текст сообщения.
     */
    @JsonProperty(value = "text")
    public String text;

    /**
     * Текст сообщения на английском (может быть не заполнен).
     */
    @JsonProperty(value = "textEn")
    public String textEn;

    @JsonProperty(value = "textEs")
    public String textEs;

    /**
     * Гиперссылка на более подробный материал.
     */
    @JsonProperty(value = "link")
    public String link;

    /**
     * Геопривязка сообщения, возможно, множественная.
     */
    @JsonProperty(value = "linking")
    public List<Link> links;

    /**
     * Уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    @JsonProperty(value = "authorDeviceId")
    public String authorDeviceId;

    /**
     * Статус важности источника, одно из значений: passenger, massmedia, official.
     */
    @JsonProperty(value = "authorStatus")
    public AuthorStatus authorStatus;

    /**
     * Количество голосов подтверждения.
     */
    @JsonProperty(value = "confirms")
    public Integer confirms;

    /**
     * Количество голосов опровержения.
     */
    @JsonProperty(value = "refutes")
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
    @JsonProperty(value = "selfVote")
    public Vote selfVote;

    public enum AuthorStatus {

        passenger,
        massmedia,
        official

    }

    public enum Vote {

        confirm,
        refute

    }

    public static class Link {

        @JsonProperty(value = "latitude")
        public Double latitude;

        @JsonProperty(value = "longitude")
        public Double longitude;

        @JsonProperty(value = "radius")
        public Double radius;

        @JsonProperty(value = "KS_ID")
        public Integer ksId;

        @JsonProperty(value = "transportHullno")
        public Integer transportHullNo;

    }

}
