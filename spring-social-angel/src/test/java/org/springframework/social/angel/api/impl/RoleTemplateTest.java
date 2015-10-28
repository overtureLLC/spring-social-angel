package org.springframework.social.angel.api.impl;

import org.junit.Test;
import org.springframework.social.angel.api.impl.model.AngelStartUpRole;
import org.springframework.social.angel.api.impl.model.PagedList;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by ryo on 10/26/15.
 */
public class RoleTemplateTest extends AbstractAngelApiTest {

    @Test
    public void getCurrentUserRoles(){
        mockServer.expect(requestTo(agUrl("/startup_roles?v1")))
                .andExpect(method(GET))
                .andRespond(withSuccess(jsonResource("angel-roles"), APPLICATION_JSON));
        PagedList<AngelStartUpRole> startUpRolesList = angel.roleOperations().getCurrentUserRoles();
        assertEquals(2, startUpRolesList.size());
        AngelStartUpRole startUpRole1 = startUpRolesList.get(0);
        assertEquals(13180,startUpRole1.getId());
        assertEquals(6702,startUpRole1.getStartUp().getId());
        AngelStartUpRole startUpRole2 = startUpRolesList.get(1);
        assertEquals(1040476, startUpRole2.getId());
        assertEquals(318369,startUpRole2.getStartUp().getId());
    }


}
