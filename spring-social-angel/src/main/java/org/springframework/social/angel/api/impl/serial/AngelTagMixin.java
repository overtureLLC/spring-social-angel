package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AngelTagMixin extends AngelObjectMixin{
    @JsonCreator
    AngelTagMixin(
            @JsonProperty("id") long id,
            @JsonProperty("tag_type") String tagType,
            @JsonProperty("name") String name) {}

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("angellist_url")
    private String angellistUrl;

}
