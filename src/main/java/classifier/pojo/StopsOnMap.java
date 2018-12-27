package classifier.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class StopsOnMap {

    /**
     * Идентификатор геопортального слоя с остановками.
     */
    @Element(name = "layerName")
    public String layerName;

    @ElementList(entry = "stop", inline = true)
    public List<StopOnMap> stopsOnMap;

}
