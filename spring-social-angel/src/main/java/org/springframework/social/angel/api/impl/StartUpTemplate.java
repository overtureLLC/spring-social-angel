package org.springframework.social.angel.api.impl;

import org.springframework.social.angel.api.StartUpOperations;
import org.springframework.social.angel.api.impl.model.AngelStartUp;
import org.springframework.social.angel.api.impl.model.AngelStartUpRoleList;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ryo on 10/28/15.
 */
public class StartUpTemplate implements StartUpOperations {
    private final RestTemplate restTemplate;
    private final AngelTemplate angelTemplate;

    public StartUpTemplate(AngelTemplate angelTemplate,RestTemplate restTemplate) {
        this.angelTemplate = angelTemplate;
        this.restTemplate = restTemplate;
    }


    @Override
    public AngelStartUp getStartUp(long startUpId) {
        return restTemplate.getForObject(angelTemplate.buildUri("/startups/"+ String.valueOf(startUpId)), AngelStartUp.class);
    }
}
