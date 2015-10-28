package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.angel.api.impl.model.AngelStartUp;

import java.util.Date;
import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class AngelStartUpRoleMixin extends AngelObjectMixin{
    @JsonCreator
    AngelStartUpRoleMixin(
            @JsonProperty("id") long id,
            @JsonProperty("role") String role,
            @JsonProperty("title") String title) {}

    @JsonProperty("confirmed")
    private boolean confirmed;

    @JsonProperty("startup")
    private AngelStartUp startUp;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("started_at")
    private String startedAt;

//    @JsonProperty("ended_at")
//    private Date endedAt;

}
