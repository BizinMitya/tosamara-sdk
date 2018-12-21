package api.record.response;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class FullStops {

    @ElementList(entry = "stop", inline = true)
    private List<FullStop> stops;

    public FullStops() {
    }

    public List<FullStop> getStops() {
        return stops;
    }

    public void setStops(List<FullStop> stops) {
        this.stops = stops;
    }

}
