package org.springframework.social.angel.security;

import org.springframework.social.angel.api.Angel;
import org.springframework.social.angel.connect.AngelConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelAuthenticationService extends OAuth2AuthenticationService<Angel> {

    public AngelAuthenticationService(String apiKey, String appSecret) {
        super(new AngelConnectionFactory(apiKey, appSecret));
    }

    public AngelAuthenticationService(String apiKey, String appSecret, String appNamespace) {
        super(new AngelConnectionFactory(apiKey, appSecret, appNamespace));
    }

}
