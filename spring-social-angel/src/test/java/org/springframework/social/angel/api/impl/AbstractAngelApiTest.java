package org.springframework.social.angel.api.impl;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.angel.api.Angel;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * Created by ryo on 10/26/15.
 */
public class AbstractAngelApiTest {
    protected AngelTemplate angel;

    protected AngelTemplate appAuthAngel;

    protected MockRestServiceServer mockServer;

    protected MockRestServiceServer appAuthMockServer;

    protected static final String ACCESS_TOKEN = "someAccessToken";
    protected static final String APP_ACCESS_TOKEN = "f137a8f4739ff9c17494c8dc59e8a9c5fb9d2de6c4f1f782";

    @Before
    public void setup() {
        angel = new AngelTemplate(ACCESS_TOKEN, "CLIENT_ID","ANGELLIST_NAMESPACE");
        mockServer = MockRestServiceServer.createServer(angel.getRestTemplate());
        appAuthAngel = new AngelTemplate(APP_ACCESS_TOKEN);
        appAuthMockServer = MockRestServiceServer.createServer(appAuthAngel.getRestTemplate());
    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }

    protected String agUrl(String path) {
        return Angel.API_URL + path;
    }

}
