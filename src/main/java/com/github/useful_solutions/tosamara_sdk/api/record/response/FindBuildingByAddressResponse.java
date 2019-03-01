package com.github.useful_solutions.tosamara_sdk.api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.Building;

import java.util.List;

public class FindBuildingByAddressResponse {

    @JsonProperty
    public List<Building> buildings;

}
