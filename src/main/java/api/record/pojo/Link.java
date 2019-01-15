package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {

    /**
     * Широта центра сообщения в WGS 84.
     */
    @JsonProperty(value = "LATITUDE")
    public Double latitude;

    /**
     * Долгота центра сообщения в WGS 84.
     */
    @JsonProperty(value = "LONGITUDE")
    public Double longitude;

    /**
     * Радиус окрестности, в которой сообщение стоит показывать, в метрах.
     */
    @JsonProperty(value = "RADIUS")
    public Double radius;

    /**
     * Классификаторный номер остановки, с которой связано сообщение.
     */
    @JsonProperty(value = "KS_ID")
    public Integer ksId;

    /**
     * Учетный номер транспортного средства, с которым связано сообщение.
     */
    @JsonProperty(value = "TRANSPORTHULLNO")
    public Integer transportHullNo;

    public Link(Double latitude, Double longitude, Double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public Link() {
    }
}
