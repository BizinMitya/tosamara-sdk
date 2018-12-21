package api.record.response;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class Stops {

    @ElementList(entry = "stop", inline = true)
    private List<Stop> stops;

    public Stops() {
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

}
