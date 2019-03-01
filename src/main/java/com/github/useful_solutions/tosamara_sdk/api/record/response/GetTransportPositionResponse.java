package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetTransportPositionResponse {

    /**
     * Классификаторный номер маршрута, на котором сейчас транспорт.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    @JsonProperty
    public Double latitude;

    @JsonProperty
    public Double longitude;

    /**
     * Название модели транспорта.
     */
    @JsonProperty
    public String modelTitle;

    /**
     * Остановки, которые транспорту предстоит пройти, в порядке следования.
     */
    @JsonProperty
    public List<Stop> nextStops;

    /**
     * Оставшаяся часть пути до ближайшей по ходу движения остановки, в метрах.
     */
    @JsonProperty
    public Double remainingLength;

    /**
     * Длина участка между остановками, на котором находится транспорт, в метрах.
     */
    @JsonProperty
    public Double spanLength;

    /**
     * Автомобильный или парковый номер транспорта.
     */
    @JsonProperty
    public String stateNumber;

    static public class Stop {

        /**
         * Классификаторный номер остановки.
         */
        @JsonProperty(value = "KS_ID")
        public Integer ksId;

        /**
         * Время прибытия на остановку, в секундах.
         */
        @JsonProperty
        public Double time;

    }

    @JsonProperty(value = "ExceptionReport")
    public ExceptionReport exceptionReport;

    public boolean isValid() {
        return exceptionReport == null;
    }

}
