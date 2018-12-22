package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FindShortestPathResponse {

    /**
     * Время выполнения маршрута в секундах.
     */
    @JsonProperty(value = "time")
    public Integer time;

    /**
     * Стоимость проезда в рублях.
     */
    @JsonProperty(value = "price")
    public Integer price;

    /**
     * Длина маршрута в метрах.
     */
    @JsonProperty(value = "length")
    public Integer lenght;

    /**
     * Количество поездок (значение более 1 означает, что будут пересадки).
     */
    @JsonProperty(value = "transportTakes")
    public Integer transportTakes;

    @JsonProperty(value = "actions")
    public List<Action> actions;
}
