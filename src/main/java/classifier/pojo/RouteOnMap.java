package classifier.pojo;

import org.simpleframework.xml.Element;

public class RouteOnMap {

    /**
     * Классификаторный номер маршрута.
     */
    @Element(name = "KR_ID")
    public Integer krId;

    /**
     * Идентификатор геопортального объекта маршрута.
     */
    @Element(name = "geoportalId")
    public Integer geoportalId;

    /**
     * Идентификатор геопортального слоя с маршрутом.
     */
    @Element(name = "layerName")
    public String layerName;

}
