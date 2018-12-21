package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transport {

    /**
     * Тип транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * Классификаторный номер маршрута.
     */
    @JsonProperty(value = "number")
    private Integer number;

    @JsonProperty(value = "KR_ID")
    private Integer krId;

    /**
     * Время до прибытия транспорта на остановку.
     */
    @JsonProperty(value = "time")
    private Integer time;

    /**
     * Идентификатор транспорта.
     */
    @JsonProperty(value = "hullNo")
    private Integer hullNo;

    /**
     * Номер госрегистрации.
     */
    @JsonProperty(value = "stateNumber")
    private String stateNumber;

    /**
     * Название модели транспорта.
     */
    @JsonProperty(value = "modelTitle")
    private String modelTitle;

    /**
     * Флаг доступности для людей с ограниченными возможностями.
     */
    @JsonProperty(value = "forInvalid")
    private Boolean forInvalid;

    /**
     * Классификаторный номер остановки, для которой запрошен прогноз (помогает разобраться при запросе на несколько остановок сразу).
     */
    @JsonProperty(value = "requestedStopId")
    private Integer requestedStopId;

    @JsonProperty(value = "nextStopId")
    private Integer nextStopId;

    /**
     * Время до прибытия транспорта на остановку в секундах.
     */
    @JsonProperty(value = "timeInSeconds")
    private Double timeInSeconds;

    /**
     * Название следующей остановки.
     */
    @JsonProperty(value = "nextStopName")
    private String nextStopName;

    /**
     * Расстояние между остановками (в метрах).
     */
    @JsonProperty(value = "spanLength")
    private Double spanLength;

    /**
     * Оставшаяся часть пути (в метрах).
     */
    @JsonProperty(value = "remainingLength")
    private Double remainingLength;

    /**
     * Признак качества прогноза, варианты значений:
     * realtime - уверенный по мониторингу реального времени,
     * schedule - предсказан на основе расписаний,
     * offroute - транспорт вне планового маршрута,
     * unattached - неуверенно определен маршрут или направление,
     * damaged - транспорт поврежден и может не принимать пассажиров
     */
    @JsonProperty(value = "quality")
    private String quality;

    /**
     * Время прибытия на остановку в секундах, если бы транспорт не отклонялся от расписания.
     */
    @JsonProperty(value = "scheduleTimeTo")
    private Double scheduleTimeTo;

    /**
     * Абсолютное время выхода в настоящий рейс (не на эту остановку!) по расписанию в формате "12:37:15".
     */
    @JsonProperty(value = "scheduleDepartureTime")
    private String scheduleDepartureTime;

    /**
     * Время, которое транспорт простоит на остановке по расписанию в секундах (часто будет 0, но для электричек не 0).
     */
    @JsonProperty(value = "delayTime")
    private Double delayTime;

    public Transport() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getKrId() {
        return krId;
    }

    public void setKrId(Integer krId) {
        this.krId = krId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getHullNo() {
        return hullNo;
    }

    public void setHullNo(Integer hullNo) {
        this.hullNo = hullNo;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public String getModelTitle() {
        return modelTitle;
    }

    public void setModelTitle(String modelTitle) {
        this.modelTitle = modelTitle;
    }

    public Boolean getForInvalid() {
        return forInvalid;
    }

    public void setForInvalid(Boolean forInvalid) {
        this.forInvalid = forInvalid;
    }

    public Integer getRequestedStopId() {
        return requestedStopId;
    }

    public void setRequestedStopId(Integer requestedStopId) {
        this.requestedStopId = requestedStopId;
    }

    public Integer getNextStopId() {
        return nextStopId;
    }

    public void setNextStopId(Integer nextStopId) {
        this.nextStopId = nextStopId;
    }

    public Double getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(Double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public String getNextStopName() {
        return nextStopName;
    }

    public void setNextStopName(String nextStopName) {
        this.nextStopName = nextStopName;
    }

    public Double getSpanLength() {
        return spanLength;
    }

    public void setSpanLength(Double spanLength) {
        this.spanLength = spanLength;
    }

    public Double getRemainingLength() {
        return remainingLength;
    }

    public void setRemainingLength(Double remainingLength) {
        this.remainingLength = remainingLength;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Double getScheduleTimeTo() {
        return scheduleTimeTo;
    }

    public void setScheduleTimeTo(Double scheduleTimeTo) {
        this.scheduleTimeTo = scheduleTimeTo;
    }

    public String getScheduleDepartureTime() {
        return scheduleDepartureTime;
    }

    public void setScheduleDepartureTime(String scheduleDepartureTime) {
        this.scheduleDepartureTime = scheduleDepartureTime;
    }

    public Double getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Double delayTime) {
        this.delayTime = delayTime;
    }

}
