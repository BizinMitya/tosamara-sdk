package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.AffiliationConverter;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.BooleanConverter;
import com.github.useful_solutions.tosamara_sdk.classifier.converter.TransportTypeConverter;
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
    @Element
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @Element
    public String direction;

    /**
     * Направление движения на английском языке.
     */
    @Element
    public String directionEn;

    /**
     *
     */
    @Element(required = false)
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
    @Element
    public Integer transportTypeID;

    /**
     * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @Element
    @Convert(TransportTypeConverter.class)
    public TransportType transportType;

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
    @Element
    public Integer affiliationID;

    /**
     * Принадлежность маршрута: муниципальный, коммерческий, пригородный, сезонный (дачный), специальный, междугородный.
     */
    @Element
    @Convert(AffiliationConverter.class)
    public Affiliation affiliation;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @Element
    @Convert(BooleanConverter.class)
    public Boolean realtimeForecast;

}
