package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    /**
     * Идентификатор сообщения.
     */
    @JsonProperty(value = "id")
    private Integer id;

    /**
     * Дата и время добавления сообщения.
     */
    @JsonProperty(value = "creationTimestamp")
    private String creationTimestamp;

    /**
     * Дата и время потери актуальности сообщения.
     */
    @JsonProperty(value = "expireTimestamp")
    private String expireTimestamp;

    /**
     * Текст сообщения.
     */
    @JsonProperty(value = "text")
    private String text;

    /**
     * Текст сообщения на английском (может быть не заполнен).
     */
    @JsonProperty(value = "textEn")
    private String textEn;

    @JsonProperty(value = "textEs")
    private String textEs;

    /**
     * Гиперссылка на более подробный материал.
     */
    @JsonProperty(value = "link")
    private String link;

    /**
     * Геопривязка сообщения, возможно, множественная.
     */
    @JsonProperty(value = "linking")
    private List<GeoPoint> geoPoints;

    /**
     * Уникальный идентификатор пользовательского устройства (UDID или DeviceID).
     */
    @JsonProperty(value = "authorDeviceId")
    private String authorDeviceId;

    /**
     * Статус важности источника, одно из значений: passenger, massmedia, official.
     */
    @JsonProperty(value = "authorStatus")
    private String authorStatus;

    /**
     * Количество голосов подтверждения.
     */
    @JsonProperty(value = "confirms")
    private Integer confirms;

    /**
     * Количество голосов опровержения.
     */
    @JsonProperty(value = "refutes")
    private Integer refutes;

    /**
     * Классификаторный номер остановки, с которой связано сообщение.
     */
    @JsonProperty(value = "KS_ID")
    private Integer ksId;

    /**
     * Учетный номер транспортного средства, с которым связано сообщение.
     */
    @JsonProperty(value = "transportHullno")
    private Integer transportHullNo;

    /**
     * Голос, отданный за данное сообщение самим запрашивающим пользователем, одно из значений: confirm, refute.
     */
    @JsonProperty(value = "selfVote")
    private String selfVote;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public String getExpireTimestamp() {
        return expireTimestamp;
    }

    public void setExpireTimestamp(String expireTimestamp) {
        this.expireTimestamp = expireTimestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    public String getTextEs() {
        return textEs;
    }

    public void setTextEs(String textEs) {
        this.textEs = textEs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<GeoPoint> getGeoPoints() {
        return geoPoints;
    }

    public void setGeoPoints(List<GeoPoint> geoPoints) {
        this.geoPoints = geoPoints;
    }

    public String getAuthorDeviceId() {
        return authorDeviceId;
    }

    public void setAuthorDeviceId(String authorDeviceId) {
        this.authorDeviceId = authorDeviceId;
    }

    public String getAuthorStatus() {
        return authorStatus;
    }

    public void setAuthorStatus(String authorStatus) {
        this.authorStatus = authorStatus;
    }

    public Integer getConfirms() {
        return confirms;
    }

    public void setConfirms(Integer confirms) {
        this.confirms = confirms;
    }

    public Integer getRefutes() {
        return refutes;
    }

    public void setRefutes(Integer refutes) {
        this.refutes = refutes;
    }

    public Integer getKsId() {
        return ksId;
    }

    public void setKsId(Integer ksId) {
        this.ksId = ksId;
    }

    public Integer getTransportHullNo() {
        return transportHullNo;
    }

    public void setTransportHullNo(Integer transportHullNo) {
        this.transportHullNo = transportHullNo;
    }

    public String getSelfVote() {
        return selfVote;
    }

    public void setSelfVote(String selfVote) {
        this.selfVote = selfVote;
    }
}
