package api.record.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Report {

    @JsonProperty(value = "ExceptionReport")
    public ExceptionReport exceptionReport;

    @Override
    public String toString() {
        return exceptionReport.toString();
    }

}
