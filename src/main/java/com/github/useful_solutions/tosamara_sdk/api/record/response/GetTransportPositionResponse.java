package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetTransportPositionResponse {

    /**
     * Классификаторный номер маршрута, на котором сейчас транспорт.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    public Double latitude;

    public Double longitude;

    /**
     * Название модели транспорта.
     */
    public String modelTitle;

    /**
     * Остановки, которые транспорту предстоит пройти, в порядке следования.
     */
    public List<Stop> nextStops;

    /**
     * Оставшаяся часть пути до ближайшей по ходу движения остановки, в метрах.
     */
    public Double remainingLength;

    /**
     * Длина участка между остановками, на котором находится транспорт, в метрах.
     */
    public Double spanLength;

    /**
     * Автомобильный или парковый номер транспорта.
     */
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
        public Double time;

    }

    @JsonProperty(value = "ExceptionReport")
    public ExceptionReport exceptionReport;

    public boolean isValid() {
        return exceptionReport == null;
    }

}
