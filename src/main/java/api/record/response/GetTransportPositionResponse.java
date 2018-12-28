package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetTransportPositionResponse {

    /**
     * Классификаторный номер маршрута, на котором сейчас транспорт.
     */
    @JsonProperty(value = "KR_ID")
    public Integer krId;

    @JsonProperty(value = "latitude")
    public Double latitude;

    @JsonProperty(value = "longitude")
    public Double longitude;

    /**
     * Название модели транспорта.
     */
    @JsonProperty(value = "modelTitle")
    public String modelTitle;

    /**
     * Остановки, которые транспорту предстоит пройти, в порядке следования.
     */
    @JsonProperty(value = "nextStops")
    public List<Stop> nextStops;

    /**
     * Оставшаяся часть пути до ближайшей по ходу движения остановки, в метрах.
     */
    @JsonProperty(value = "remainingLength")
    public Double remainingLength;

    /**
     * Длина участка между остановками, на котором находится транспорт, в метрах.
     */
    @JsonProperty(value = "spanLength")
    public Double spanLength;

    /**
     * Автомобильный или парковый номер транспорта.
     */
    @JsonProperty(value = "stateNumber")
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
        @JsonProperty(value = "time")
        public Double time;

    }

}
