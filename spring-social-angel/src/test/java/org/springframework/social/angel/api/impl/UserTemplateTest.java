package org.springframework.social.angel.api.impl;

import org.junit.Test;
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
public class UserTemplateTest extends AbstractAngelApiTest {

    @Test
    public void getUserProfile(){
        mockServer.expect(requestTo(agUrl("/me")))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("angel-profile"), APPLICATION_JSON));
        assertEquals(155, angel.userOperations().getProfileId());
    }

    @Test
    public void getUserProfile_Id(){
        mockServer.expect(requestTo(agUrl("/users/155")))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("angel-profile"), APPLICATION_JSON));
        assertEquals("Naval Ravikant", angel.userOperations().getUserProfile(155).getName());
    }

    @Test
    public void getUserRoles_Id(){
        mockServer.expect(requestTo(agUrl("/users/199344/roles")))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("angel-roles"), APPLICATION_JSON));
        PagedList<AngelStartUpRole> startUpRolesList = angel.userOperations().getUserRoles(199344);
        assertEquals(2, startUpRolesList.size());
        AngelStartUpRole startUpRole1 = startUpRolesList.get(0);
        assertEquals(13180,startUpRole1.getId());
        assertEquals(6702,startUpRole1.getStartUp().getId());
        AngelStartUpRole startUpRole2 = startUpRolesList.get(1);
        assertEquals(1040476,startUpRole2.getId());
        assertEquals(318369,startUpRole2.getStartUp().getId());
    }


}
