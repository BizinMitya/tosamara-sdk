package api.record.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LastRace {

    @JsonProperty(value = "endControlPoint")
    public String endControlPoint;

    @JsonProperty(value = "endTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Samara")
    public Date endTime;

    @JsonProperty(value = "startControlPoint")
    public String startControlPoint;

    @JsonProperty(value = "startTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Samara")
    public Date startTime;

}
