package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.github.useful_solutions.tosamara_sdk.api.record.pojo.TransportType;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.AffiliationDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.BitDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.deserializer.TransportTypeDeserializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.AffiliationSerializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.BitSerializer;
import com.github.useful_solutions.tosamara_sdk.classifier.serializer.TransportTypeSerializer;

public class Route {

    /**
     * Классификаторный номер маршрута.
     */
    @JacksonXmlProperty(localName = "KR_ID")
    public Integer krId;

    /**
     * Номер маршрута, тот, что пишется на табличках.
     */
    @JacksonXmlProperty
    public String number;

    /**
     * Направление движения, обычно — конечная остановка.
     */
    @JacksonXmlProperty
    public String direction;

    /**
     * Направление движения на английском языке.
     */
    @JacksonXmlProperty
    public String directionEn;

    /**
     *
     */
    @JacksonXmlProperty
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
    @JacksonXmlProperty
    public Integer transportTypeID;

    /**
     * Вид транспорта: автобус, трамвай, троллейбус, метрополитен, электропоезд, речной транспорт.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = TransportTypeDeserializer.class)
    @JsonSerialize(using = TransportTypeSerializer.class)
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
    @JacksonXmlProperty
    public Integer affiliationID;

    /**
     * Принадлежность маршрута: муниципальный, коммерческий, пригородный, сезонный (дачный), специальный, междугородный.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = AffiliationDeserializer.class)
    @JsonSerialize(using = AffiliationSerializer.class)
    public Affiliation affiliation;

    /**
     * Признак того, что маршрут прогнозируется по мониторингу в реальном времени.
     */
    @JacksonXmlProperty
    @JsonDeserialize(using = BitDeserializer.class)
    @JsonSerialize(using = BitSerializer.class)
    public Boolean realtimeForecast;

}
