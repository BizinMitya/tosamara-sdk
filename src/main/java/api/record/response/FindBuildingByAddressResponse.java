package api.record.response;

import api.record.pojo.Building;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FindBuildingByAddressResponse {

    @JsonProperty(value = "buildings")
    public List<Building> buildings;

}
