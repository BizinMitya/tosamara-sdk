package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Schedule {

    @JsonProperty(value = "stopName")
    public String stopName;

    @JsonProperty(value = "time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm", timezone = "Europe/Samara")
    public List<Date> time;

}
