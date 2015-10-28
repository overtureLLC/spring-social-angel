package org.springframework.social.angel.api.impl;

import org.springframework.social.angel.api.*;
import org.springframework.social.angel.api.impl.model.AngelProfile;
import org.springframework.social.angel.api.impl.model.AngelStartUpRole;
import org.springframework.social.angel.api.impl.model.AngelStartUpRoleList;
import org.springframework.social.angel.api.impl.model.PagedList;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Implementation of the {@link UserOperations} interface providing binding to AngelList' user-oriented REST resources.
 * @author ryo hang
 */
class UserTemplate implements UserOperations {

    private final RestTemplate restTemplate;
    private final AngelTemplate angelTemplate;

    public UserTemplate(AngelTemplate angelTemplate,RestTemplate restTemplate) {
        this.angelTemplate = angelTemplate;
        this.restTemplate = restTemplate;
    }

    @Override
    public long getProfileId() {
        return getUserProfile().getId();
    }

    @Override
    public AngelProfile getUserProfile() {
        return restTemplate.getForObject(angelTemplate.buildUri("/me"), AngelProfile.class);
    }

    @Override
    public AngelProfile getUserProfile(long userId) {
        return restTemplate.getForObject(angelTemplate.buildUri("/users/"+userId), AngelProfile.class);
    }

    @Override
    public PagedList<AngelStartUpRole> getUserRoles(long userId) {
        return restTemplate.getForObject(angelTemplate.buildUri("/users/" + String.valueOf(userId) + "/roles"), AngelStartUpRoleList.class).getList();
    }

    @Override
    public List<AngelProfile> searchForUsers(String query) {
        return null;
    }

    @Override
    public List<AngelProfile> searchForUsers(String query, int page, int pageSize) {
        return null;
    }
}
