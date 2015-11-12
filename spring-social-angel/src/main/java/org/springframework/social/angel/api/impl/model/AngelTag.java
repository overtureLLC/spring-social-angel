package org.springframework.social.angel.api.impl.model;

import java.io.Serializable;

/**
 * Created by ryo on 10/28/15.
 */
public class AngelTag extends AngelObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private final long id;
    private final String tagType;
    private final String name;
    private String displayName;
    private String angellistUrl;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public AngelTag(long id, String tagType, String name) {
        this.id = id;
        this.tagType = tagType;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getTagType() {
        return tagType;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAngellistUrl() {
        return angellistUrl;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setAngellistUrl(String angellistUrl) {
        this.angellistUrl = angellistUrl;
    }

}
