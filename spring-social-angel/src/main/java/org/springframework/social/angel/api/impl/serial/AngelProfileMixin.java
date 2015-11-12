package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AngelProfileMixin extends AngelObjectMixin{
    @JsonCreator
    AngelProfileMixin(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("image") String image,
            @JsonProperty("bio") String bio) {}

    @JsonProperty("blog_url")
    private String blogUrl;

    @JsonProperty("online_bio_url")
    private String onlineBioUrl;

    @JsonProperty("twitter_url")
    private String twitterUrl;

    @JsonProperty("facebook_url")
    private String facebookUrl;

    @JsonProperty("linkedin_url")
    private String linkedinUrl;

    @JsonProperty("angellist_url")
    private String angellistUrl;

    @JsonProperty("follower_count")
    private int followerCount;

    @JsonProperty("investor")
    private boolean investor;

    @JsonProperty("roles")
    private List roles;

    @JsonProperty("locations")
    private List locations;

}
