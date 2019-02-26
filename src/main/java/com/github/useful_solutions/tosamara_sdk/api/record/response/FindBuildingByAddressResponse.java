package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Building;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FindBuildingByAddressResponse {

    @JsonProperty(value = "buildings")
    public List<Building> buildings;

}
