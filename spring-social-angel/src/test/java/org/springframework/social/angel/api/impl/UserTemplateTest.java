package org.springframework.social.angel.api.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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


}
