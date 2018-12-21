package api.record.response;

import api.entities.Action;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FindShortestPathResponse {

    @JsonProperty(value = "time")
    public Integer time;

    @JsonProperty(value = "price")
    public Integer price;

    @JsonProperty(value = "length")
    public Integer lenght;

    @JsonProperty(value = "transportTakes")
    public Integer transportTakes;

    @JsonProperty(value = "actions")
    public List<Action> actions;
}
