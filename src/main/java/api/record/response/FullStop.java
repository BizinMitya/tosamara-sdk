package api.record.response;

import org.simpleframework.xml.Element;

public class FullStop {

    /**
     * Классификаторный номер остановки.
     */
    @Element(name = "KS_ID")
    private Integer ksId;

    /**
     * Собственное название.
     */
    @Element(name = "title", required = false)
    private String title;

    /**
     * Улица, на которой расположена остановка.
     */
    @Element(name = "adjacentStreet", required = false)
    private String adjacentStreet;

    /**
     * Преимущественное направление движения.
     */
    @Element(name = "direction", required = false)
    private String direction;

    /**
     * Собственное название на английском языке.
     */
    @Element(name = "titleEn", required = false)
    private String titleEn;

    /**
     * Улица на английском.
     */
    @Element(name = "adjacentStreetEn", required = false)
    private String adjacentStreetEn;

    /**
     * Преимущественное направление движения на английском.
     */
    @Element(name = "directionEn", required = false)
    private String directionEn;

    @Element(name = "titleEs", required = false)
    private String titleEs;

    @Element(name = "adjacentStreetEs", required = false)
    private String adjacentStreetEs;

    @Element(name = "directionEs", required = false)
    private String directionEs;

    /**
     * Номер остановочного кластера, редко заполнен.
     */
    @Element(name = "cluster", required = false)
    private String cluster;

    /**
     * Перечисление маршрутов муниципальных автобусов, проходящих через остановку.
     */
    @Element(name = "busesMunicipal", required = false)
    private String busesMunicipal;

    /**
     * Перечисление маршрутов коммерческих автобусов.
     */
    @Element(name = "busesCommercial", required = false)
    private String busesCommercial;

    /**
     * Перечисление маршрутов пригородных автобусов.
     */
    @Element(name = "busesPrigorod", required = false)
    private String busesPrigorod;

    /**
     * Перечисление маршрутов сезонных (дачных) автобусов.
     */
    @Element(name = "busesSeason", required = false)
    private String busesSeason;

    /**
     * Перечисление маршрутов специальных автобусов.
     */
    @Element(name = "busesSpecial", required = false)
    private String busesSpecial;

    /**
     * Перечисление маршрутов междугородных автобусов.
     */
    @Element(name = "busesIntercity", required = false)
    private String busesIntercity;

    /**
     * Перечисление маршрутов трамваев.
     */
    @Element(name = "trams", required = false)
    private String trams;

    /**
     * Перечисление маршрутов троллейбусов.
     */
    @Element(name = "trolleybuses", required = false)
    private String trolleybuses;

    /**
     * Перечисление линий метрополитена (на самом деле, линия в Самаре одна).
     */
    @Element(name = "metros", required = false)
    private String metros;

    /**
     * Перечисление маршрутов электропоездов.
     */
    @Element(name = "electricTrains", required = false)
    private String electricTrains;

    /**
     * Перечисление маршрутов речных переправ.
     */
    @Element(name = "riverTransports", required = false)
    private String riverTransports;

    /**
     * Признак наличия на остановке информационного табло.
     */
    @Element(name = "infotabloExists")
    private String infotabloExists;

    /**
     * Географическая северная широта остановки, в градусах.
     */
    @Element(name = "latitude")
    private Double latitude;

    /**
     * Географическая восточная долгота остановки, в градусах.
     */
    @Element(name = "longitude")
    private Double longitude;

    @Element(name = "angle", required = false)
    private Integer angle;

    public FullStop() {
    }

    public Integer getKsId() {
        return ksId;
    }

    public void setKsId(Integer ksId) {
        this.ksId = ksId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdjacentStreet() {
        return adjacentStreet;
    }

    public void setAdjacentStreet(String adjacentStreet) {
        this.adjacentStreet = adjacentStreet;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getAdjacentStreetEn() {
        return adjacentStreetEn;
    }

    public void setAdjacentStreetEn(String adjacentStreetEn) {
        this.adjacentStreetEn = adjacentStreetEn;
    }

    public String getDirectionEn() {
        return directionEn;
    }

    public void setDirectionEn(String directionEn) {
        this.directionEn = directionEn;
    }

    public String getTitleEs() {
        return titleEs;
    }

    public void setTitleEs(String titleEs) {
        this.titleEs = titleEs;
    }

    public String getAdjacentStreetEs() {
        return adjacentStreetEs;
    }

    public void setAdjacentStreetEs(String adjacentStreetEs) {
        this.adjacentStreetEs = adjacentStreetEs;
    }

    public String getDirectionEs() {
        return directionEs;
    }

    public void setDirectionEs(String directionEs) {
        this.directionEs = directionEs;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getBusesMunicipal() {
        return busesMunicipal;
    }

    public void setBusesMunicipal(String busesMunicipal) {
        this.busesMunicipal = busesMunicipal;
    }

    public String getBusesCommercial() {
        return busesCommercial;
    }

    public void setBusesCommercial(String busesCommercial) {
        this.busesCommercial = busesCommercial;
    }

    public String getBusesPrigorod() {
        return busesPrigorod;
    }

    public void setBusesPrigorod(String busesPrigorod) {
        this.busesPrigorod = busesPrigorod;
    }

    public String getBusesSeason() {
        return busesSeason;
    }

    public void setBusesSeason(String busesSeason) {
        this.busesSeason = busesSeason;
    }

    public String getBusesSpecial() {
        return busesSpecial;
    }

    public void setBusesSpecial(String busesSpecial) {
        this.busesSpecial = busesSpecial;
    }

    public String getBusesIntercity() {
        return busesIntercity;
    }

    public void setBusesIntercity(String busesIntercity) {
        this.busesIntercity = busesIntercity;
    }

    public String getTrams() {
        return trams;
    }

    public void setTrams(String trams) {
        this.trams = trams;
    }

    public String getTrolleybuses() {
        return trolleybuses;
    }

    public void setTrolleybuses(String trolleybuses) {
        this.trolleybuses = trolleybuses;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getElectricTrains() {
        return electricTrains;
    }

    public void setElectricTrains(String electricTrains) {
        this.electricTrains = electricTrains;
    }

    public String getRiverTransports() {
        return riverTransports;
    }

    public void setRiverTransports(String riverTransports) {
        this.riverTransports = riverTransports;
    }

    public String getInfotabloExists() {
        return infotabloExists;
    }

    public void setInfotabloExists(String infotabloExists) {
        this.infotabloExists = infotabloExists;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getAngle() {
        return angle;
    }

    public void setAngle(Integer angle) {
        this.angle = angle;
    }

}
