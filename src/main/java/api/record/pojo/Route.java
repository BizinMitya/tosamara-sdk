package api.record.pojo;

import org.simpleframework.xml.Element;

public class Route {

    @Element(name = "KR_ID")
    public Integer krId;

    @Element(name = "number")
    public String number;

    @Element(name = "direction")
    public String direction;

    @Element(name = "directionEn")
    public String directionEn;

    @Element(name = "directionEs", required = false)
    public String directionEs;

    @Element(name = "transportTypeID")
    public Integer transportTypeID;

    @Element(name = "transportType")
    public String transportType;

    @Element(name = "affiliationID")
    public Integer affiliationID;

    @Element(name = "affiliation")
    public String affiliation;

    @Element(name = "realtimeForecast")
    public Integer realtimeForecast;

}
