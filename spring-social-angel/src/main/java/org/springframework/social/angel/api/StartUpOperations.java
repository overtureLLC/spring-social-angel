package org.springframework.social.angel.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.angel.api.impl.model.AngelStartUp;
import org.springframework.social.angel.api.impl.model.AngelStartUpRole;
import org.springframework.social.angel.api.impl.model.PagedList;

/**
 * Created by ryo on 10/28/15.
 */
public interface StartUpOperations {

    /**
     * Retrieves a specific AngelList startup details.
     * Supports either user or application authorization.
     * @return a {@link AngelStartUp} object representing the user's roles.
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials or an application access token.
     */
    AngelStartUp getStartUp(long startUpId);

}
