package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AngelStartUpMixin extends AngelObjectMixin{
    @JsonCreator
    AngelStartUpMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name) {}

    @JsonProperty("hidden")
    private boolean hidden;

    @JsonProperty("community_profile")
    private boolean communityProfile;

    @JsonProperty("angellist_url")
    private String angellistUrl;

    @JsonProperty("logo_url")
    private String logoUrl;

    @JsonProperty("thumb_url")
    private String thumbUrl;

    @JsonProperty("quality")
    private int quality;

    @JsonProperty("product_desc")
    private String productDesc;

    @JsonProperty("high_concept")
    private String highConcept;

    @JsonProperty("follower_count")
    private int followerCount;

    @JsonProperty("company_url")
    private String companyUrl;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("twitter_url")
    private String twitterUrl;

    @JsonProperty("blog_url")
    private String blogUrl;

    @JsonProperty("video_url")
    private String videoUrl;

    @JsonProperty("markets")
    private List markets;

    @JsonProperty("locations")
    private List locations;

    @JsonProperty("screenshots")
    private List screenshots;


}
