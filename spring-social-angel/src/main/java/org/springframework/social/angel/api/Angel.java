package org.springframework.social.angel.api;

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * Created by ryo on 10/25/15.
 */
public interface Angel extends ApiBinding{

    /**
     * @return the portion of the Angel API containing the user operations.
     */
    UserOperations userOperations();

    /**
     * @return the portion of the Angel API containing the role operations.
     */
    RoleOperations roleOperations();

    /**
     * @return the portion of the Angel API containing the startUp operations.
     */
    StartUpOperations startupOperations();

    /**
     * Returns the underlying {@link RestOperations} object allowing for consumption of AngelList endpoints that may not be otherwise covered by the API binding.
     * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
     * @return a RestOperations object instrumented for including an OAuth Authorization header on requests.
     */
    RestOperations restOperations();
    static final String AUTH_URL ="https://angel.co/api" ;
    static final String API_URL = "https://api.angel.co/1";
}
