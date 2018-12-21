package api.record.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class GetFirstArrivalToStopRequest implements Serializable {

    @JsonProperty(value = "method")
    private String method = "getFirstArrivalToStop";

    @JsonProperty(value = "KS_ID")
    private List<Integer> ksIds;

    @JsonProperty(value = "COUNT")
    private Integer count;

    public GetFirstArrivalToStopRequest() {
    }

    public GetFirstArrivalToStopRequest(List<Integer> ksIds, Integer count) {
        this.ksIds = ksIds;
        this.count = count;
    }

    public List<Integer> getKsIds() {
        return ksIds;
    }

    public void setKsIds(List<Integer> ksIds) {
        this.ksIds = ksIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
