package classifier.pojo;

import classifier.converter.InfotabloConverter;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.convert.Convert;

public class FullStop {

    /**
     * Классификаторный номер остановки.
     */
    @Element(name = "KS_ID")
    public Integer ksId;

    /**
     * Собственное название.
     */
    @Element(name = "title", required = false)
    public String title;

    /**
     * Улица, на которой расположена остановка.
     */
    @Element(name = "adjacentStreet", required = false)
    public String adjacentStreet;

    /**
     * Преимущественное направление движения.
     */
    @Element(name = "direction", required = false)
    public String direction;

    /**
     * Собственное название на английском языке.
     */
    @Element(name = "titleEn", required = false)
    public String titleEn;

    /**
     * Улица на английском.
     */
    @Element(name = "adjacentStreetEn", required = false)
    public String adjacentStreetEn;

    /**
     * Преимущественное направление движения на английском.
     */
    @Element(name = "directionEn", required = false)
    public String directionEn;

    @Element(name = "titleEs", required = false)
    public String titleEs;

    @Element(name = "adjacentStreetEs", required = false)
    public String adjacentStreetEs;

    @Element(name = "directionEs", required = false)
    public String directionEs;

    /**
     * Номер остановочного кластера, редко заполнен.
     */
    @Element(name = "cluster", required = false)
    public String cluster;

    /**
     * Перечисление маршрутов муниципальных автобусов, проходящих через остановку.
     */
    @Element(name = "busesMunicipal", required = false)
    public String[] busesMunicipal;

    /**
     * Перечисление маршрутов коммерческих автобусов.
     */
    @Element(name = "busesCommercial", required = false)
    public String[] busesCommercial;

    /**
     * Перечисление маршрутов пригородных автобусов.
     */
    @Element(name = "busesPrigorod", required = false)
    public String[] busesPrigorod;

    /**
     * Перечисление маршрутов сезонных (дачных) автобусов.
     */
    @Element(name = "busesSeason", required = false)
    public String[] busesSeason;

    /**
     * Перечисление маршрутов специальных автобусов.
     */
    @Element(name = "busesSpecial", required = false)
    public String[] busesSpecial;

    /**
     * Перечисление маршрутов междугородных автобусов.
     */
    @Element(name = "busesIntercity", required = false)
    public String[] busesIntercity;

    /**
     * Перечисление маршрутов трамваев.
     */
    @Element(name = "trams", required = false)
    public String[] trams;

    /**
     * Перечисление маршрутов троллейбусов.
     */
    @Element(name = "trolleybuses", required = false)
    public String[] trolleybuses;

    /**
     * Перечисление линий метрополитена (на самом деле, линия в Самаре одна).
     */
    @Element(name = "metros", required = false)
    public String[] metros;

    /**
     * Перечисление маршрутов электропоездов.
     */
    @Element(name = "electricTrains", required = false)
    public String[] electricTrains;

    /**
     * Перечисление маршрутов речных переправ.
     */
    @Element(name = "riverTransports", required = false)
    public String[] riverTransports;

    /**
     * Признак наличия на остановке информационного табло.
     */
    @Element(name = "infotabloExists")
    @Convert(InfotabloConverter.class)
    public Boolean infotabloExists;

    /**
     * Географическая северная широта остановки, в градусах.
     */
    @Element(name = "latitude")
    public Double latitude;

    /**
     * Географическая восточная долгота остановки, в градусах.
     */
    @Element(name = "longitude")
    public Double longitude;

    @Element(name = "angle", required = false)
    public Integer angle;

}
