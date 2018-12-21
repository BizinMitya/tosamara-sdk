package api.entities;

import api.record.request.GeoPoint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Action {

    @JsonProperty(value = "action")
    public String action;

    @JsonProperty(value = "length")
    public Integer length;

    @JsonProperty(value = "time")
    public Integer time;

    @JsonProperty(value = "stopFrom")
    public Integer stopFrom;

    @JsonProperty(value = "stopTo")
    public Integer stopTo;

    @JsonProperty(value = "routes")
    public Integer[] routes;

    @JsonProperty(value = "comment")
    public String comment;

    @JsonProperty(value = "geometry")
    public GeoPoint[] geometry;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("action", action)
                .add("length", length)
                .add("time", time)
                .add("stopFrom", stopFrom)
                .add("stopTo", stopTo)
                .add("routes", routes)
                .add("comment", comment)
                .add("geometry", geometry)
                .toString();
    }
}
