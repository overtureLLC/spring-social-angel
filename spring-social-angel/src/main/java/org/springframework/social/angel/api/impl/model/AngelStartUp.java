package org.springframework.social.angel.api.impl.model;

import org.springframework.social.angel.api.Angel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
public class AngelStartUp extends AngelObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private final long id;
    private boolean hidden;
    private boolean communityProfile;
    private final String name;
    private String angellistUrl;
    private String logoUrl;
    private String thumbUrl;
    private int quality;
    private String productDesc;
    private String highConcept;
    private int followerCount;
    private String companyUrl;
    private Date createdAt;
    private Date updatedAt;


    //second tier data
    private String twitterUrl;
    private String blogUrl;
    private String videoUrl;
    private List<AngelTag>  markets;
    private List<AngelTag> locations;
    private List screenshots;


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public AngelStartUp(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isCommunityProfile() {
        return communityProfile;
    }

    public String getName() {
        return name;
    }

    public String getAngellistUrl() {
        return angellistUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public int getQuality() {
        return quality;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public String getHighConcept() {
        return highConcept;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public String getCompanyUrl() {
        return companyUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public List<AngelTag> getMarkets() {
        return markets;
    }

    public List<AngelTag> getLocations() {
        return locations;
    }

    public List getScreenshots() {
        return screenshots;
    }
}
