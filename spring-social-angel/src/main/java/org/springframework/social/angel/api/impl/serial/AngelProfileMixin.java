package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.angel.api.AngelProfile;

import java.util.Date;
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
            @JsonProperty("String") String String) {}

    @JsonProperty("blog_url")
    private String blog_url;

    @JsonProperty("online_bio_url")
    private String online_bio_url;

    @JsonProperty("twitter_url")
    private String twitter_url;

    @JsonProperty("facebook_url")
    private String facebook_url;

    @JsonProperty("linkedin_url")
    private String linkedin_url;

    @JsonProperty("angellist_url")
    private String angellist_url;

    @JsonProperty("follower_count")
    private int follower_count;

    @JsonProperty("investor")
    private boolean investor;

    @JsonProperty("roles")
    private List roles;

    @JsonProperty("locations")
    private List locations;

}
