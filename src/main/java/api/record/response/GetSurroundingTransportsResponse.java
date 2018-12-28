package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetSurroundingTransportsResponse {

    @JsonProperty(value = "transports")
    public List<Transport> transports;

    public static class Transport {

        /**
         * Классификаторный номер маршрута, на котором сейчас транспорт.
         */
        @JsonProperty(value = "KR_ID")
        public Integer krId;

        /**
         * Направление движения транспорта в точке, где он сейчас находится, в градусах от 0 до 360 по тригонометрическому кругу.
         */
        @JsonProperty(value = "direction")
        public Double direction;

        /**
         * Флаг доступности для людей с ограниченными возможностями.
         */
        @JsonProperty(value = "forInvalid")
        public Boolean forInvalid;

        /**
         * Идентификатор транспорта.
         */
        @JsonProperty(value = "hullNo")
        public Integer hullNo;

        /**
         * Широта, координаты транспорта в WGS 84.
         */
        @JsonProperty(value = "latitude")
        public Double latitude;

        /**
         * Долгота, координаты транспорта в WGS 84.
         */
        @JsonProperty(value = "longitude")
        public Double longitude;

        /**
         * Название модели транспорта.
         */
        @JsonProperty(value = "modelTitle")
        public String modelTitle;

        /**
         * Классификаторный номер следующей остановки.
         */
        @JsonProperty(value = "nextStopId")
        public Integer nextStopId;

        /**
         * Номер маршрута, тот, что пишется на табличках.
         */
        @JsonProperty(value = "number")
        public String number;

        /**
         * Автомобильный или парковый номер транспорта.
         */
        @JsonProperty(value = "stateNumber")
        public String stateNumber;

        /**
         * Тип транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
         */
        @JsonProperty(value = "type")
        public String type;

    }

}
