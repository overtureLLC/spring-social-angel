package org.springframework.social.angel.connect;

import org.springframework.social.angel.api.Angel;
import org.springframework.social.angel.api.impl.AngelTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelServiceProvider extends AbstractOAuth2ServiceProvider {
    private String appNamespace;

    /**
     * Creates a AngelServiceProvider for the given application ID, secret, and namespace.
     * @param appId The application's App ID as assigned by AngelList
     * @param appSecret The application's App Secret as assigned by AngelList
     * @param appNamespace The application's App Namespace as configured with AngelList. Enables use of Open Graph operations.
     */
    public AngelServiceProvider(String appId, String appSecret, String appNamespace) {
        super(getOAuth2Template(appId, appSecret));
        this.appNamespace = appNamespace;
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret) {
        OAuth2Template oAuth2Template = new OAuth2Template(appId, appSecret,
                Angel.AUTH_URL+"/oauth/authorize",
                Angel.AUTH_URL + "/oauth/token");
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    public Angel getApi(String accessToken) {
        return new AngelTemplate(accessToken, appNamespace);
    }
}
