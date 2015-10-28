package org.springframework.social.angel.api.impl;

import org.springframework.social.angel.api.RoleOperations;
import org.springframework.social.angel.api.impl.model.AngelStartUpRole;
import org.springframework.social.angel.api.impl.model.AngelStartUpRoleList;
import org.springframework.social.angel.api.impl.model.PagedList;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ryo on 10/28/15.
 */
public class RoleTemplate implements RoleOperations {

    private final RestTemplate restTemplate;
    private final AngelTemplate angelTemplate;

    public RoleTemplate(AngelTemplate angelTemplate,RestTemplate restTemplate) {
        this.angelTemplate = angelTemplate;
        this.restTemplate = restTemplate;
    }

    @Override
    public PagedList<AngelStartUpRole> getCurrentUserRoles() {
        return restTemplate.getForObject(angelTemplate.buildUri("/startup_roles?v1"), AngelStartUpRoleList.class).getList();
    }
}
