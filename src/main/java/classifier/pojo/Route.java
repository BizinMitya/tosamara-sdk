package classifier.pojo;

import classifier.converter.BooleanConverter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;

public class Route {

    /**
     * Классификаторный номер маршрута.
     */
    @Element(name = "KR_ID")
    public Integer krId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @Element(name = "number")
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @Element(name = "direction")
    public String direction;

    /**
     * Направление движения на английском языке.
     */
    @Element(name = "directionEn")
    public String directionEn;

    /**
     *
     */
    @Element(name = "directionEs", required = false)
    public String directionEs;

    /**
     * Числовой код вида транспорта:
     * 1 — автобус,
     * 2 — метрополитен,
     * 3 — трамвай,
     * 4 — троллейбус,
     * 5 - электропоезд,
     * 6 - речной транспорт
     */
    @Element(name = "transportTypeID")
    public Integer transportTypeID;

    /**
     * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @Element(name = "transportType")
    public String transportType;

    /**
     * Числовой код принадлежность маршрута:
     * 1 — муниципальный,
     * 2 — коммерческий,
     * 3 — пригородный,
     * 4 — сезонный (дачный),
     * 5 — специальный,
     * 6 - междугородный.
     * Маршруты шаттлов включаются в "специальный автобус".
     */
    @Element(name = "affiliationID")
    public Integer affiliationID;

    /**
     * Принадлежность маршрута: муниципальный, коммерческий, пригородный, сезонный (дачный), специальный, междугородный.
     */
    @Element(name = "affiliation")
    public String affiliation;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @Element(name = "realtimeForecast")
    @Convert(BooleanConverter.class)
    public Boolean realtimeForecast;

}
