package org.springframework.social.angel.api.impl.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AngelStartUpRoleList{
    private final PagedList<AngelStartUpRole> startUpRoleList;

    @JsonCreator
    public AngelStartUpRoleList(
            @JsonProperty("startup_roles") List<AngelStartUpRole> list,
            @JsonProperty("total") long total,
            @JsonProperty("per_page") long perPage,
            @JsonProperty("page") long page,
            @JsonProperty("last_page") long lastPage) {
        this.startUpRoleList = new PagedList(list, total, perPage,page,lastPage);
    }

    @JsonIgnore
    public PagedList<AngelStartUpRole> getList() {
        return startUpRoleList;
    }

}
