package org.springframework.social.angel.api.impl;

import org.junit.Test;
import org.springframework.social.angel.api.impl.model.AngelStartUp;
import org.springframework.social.angel.api.impl.model.AngelStartUpRole;
import org.springframework.social.angel.api.impl.model.PagedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by ryo on 10/26/15.
 */
public class StartUpTemplateTest extends AbstractAngelApiTest {

    @Test
    public void getStartUp(){
        mockServer.expect(requestTo(agUrl("/startups/6702")))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("angel-startUp"), APPLICATION_JSON));
        AngelStartUp startUp = angel.startupOperations().getStartUp(6702);
        assertEquals(6702, startUp.getId());
        assertNotNull(startUp.getVideoUrl());
        assertEquals(2, startUp.getMarkets().size());
        assertEquals("MarketTag",startUp.getMarkets().get(0).getTagType());
        assertEquals("LocationTag",startUp.getLocations().get(0).getTagType());
    }


}
