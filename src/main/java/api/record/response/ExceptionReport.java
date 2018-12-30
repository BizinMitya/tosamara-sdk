package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionReport {

    @JsonProperty(value = "ExceptionText")
    public String exceptionText;

    @JsonProperty(value = "ExceptionCode")
    public String exceptionCode;

}
