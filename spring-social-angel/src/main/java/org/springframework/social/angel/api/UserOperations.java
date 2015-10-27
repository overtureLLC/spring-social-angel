package org.springframework.social.angel.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;

import java.util.List;
import java.util.Map;

/**
 * Created by ryo on 10/25/15.
 */
public interface UserOperations {
    /**
     * Retrieves the authenticated user's AngelList ID.
     * @return the user's ID at AngelList
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials.
     */
    long getProfileId();

    /**
     * Retrieves the authenticated user's AngelList profile details.
     * @return a {@link AngelProfile} object representing the user's profile.
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials.
     */
    AngelProfile getUserProfile();

    /**
     * Retrieves a specific user's AngelList profile details.
     * Supports either user or application authorization.
     * @param userId the user ID for the user whose details are to be retrieved.
     * @return a {@link AngelProfile} object representing the user's profile.
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials or an application access token.
     */
    AngelProfile getUserProfile(long userId);

    /**
     * Searches for up to 20 users that match a given query.
     * @return a list of AngelList profiles
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials.
     */
    List<AngelProfile> searchForUsers(String query);

    /**
     * Searches for users that match a given query.
     * @param page the page of search results to return
     * @param pageSize the number of {@link AngelProfile}s per page. Maximum of 20 per page.
     * @return a list of AngelList profiles
     * @throws ApiException if there is an error while communicating with AngelList.
     * @throws MissingAuthorizationException if AngelListTemplate was not created with OAuth credentials.
     */
    List<AngelProfile> searchForUsers(String query, int page, int pageSize);

}
