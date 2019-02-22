package com.useful_solutions.tosamara_sdk.api.record.request;

import com.useful_solutions.tosamara_sdk.api.record.pojo.Link;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SendUserMessageRequest {

    @JsonProperty(value = "method")
    private final String method = "sendUserMessage";

    @JsonProperty(value = "TEXT")
    private final String text;

    @JsonProperty(value = "TEXTEN")
    private final String textEn;

    @JsonProperty(value = "LINK")
    private final String link;

    @JsonProperty(value = "LINKING")
    private final List<Link> links;

    @JsonProperty(value = "EXPIRETIME")
    private final Integer expireTime;

    @JsonProperty(value = "DEVICEID")
    private final String deviceId;

    public SendUserMessageRequest(String text, String textEn, String link, List<Link> links,
                                  Integer expireTime, String deviceId) {
        this.text = text;
        this.textEn = textEn;
        this.link = link;
        this.links = links;
        this.expireTime = expireTime;
        this.deviceId = deviceId;
    }

    public String getText() {
        return text;
    }

    public String getTextEn() {
        return textEn;
    }

    public String getLink() {
        return link;
    }

    public List<Link> getLinks() {
        return links;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
