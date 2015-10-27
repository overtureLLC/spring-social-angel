package org.springframework.social.angel.connect;

import org.springframework.social.angel.api.Angel;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * AngelList ConnectionFactory implementation.
 * @author Ryo Hang
 */
public class AngelConnectionFactory extends OAuth2ConnectionFactory<Angel> {
    /**
     * Creates a AngelConnectionFactory for the given application ID and secret.
     * Using this constructor, no application namespace is set (and therefore AngelList's API operations cannot be used).
     * @param appId The application's App ID as assigned by AngelList
     * @param appSecret The application's App Secret as assigned by AngelList
     */
    public AngelConnectionFactory(String appId, String appSecret) {
        this(appId, appSecret, null);
    }

    /**
     * Creates a FacebookConnectionFactory for the given application ID, secret, and namespace.
     * @param appId The application's App ID as assigned by Facebook
     * @param appSecret The application's App Secret as assigned by Facebook
     * @param appNamespace The application's App Namespace as configured with Facebook. Enables use of Open Graph operations.
     */
    public AngelConnectionFactory(String appId, String appSecret, String appNamespace) {
        super("angellist", new AngelServiceProvider(appId, appSecret, appNamespace), new AngelAdapter());
    }
}
