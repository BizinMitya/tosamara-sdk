package api.record.response;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Stop {

    @Attribute(required = false)
    private Boolean external;

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

    public Stop() {
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

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

}
