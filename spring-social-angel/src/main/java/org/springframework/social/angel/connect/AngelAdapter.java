package org.springframework.social.angel.connect;

import org.springframework.social.ApiException;
import org.springframework.social.angel.api.Angel;
import org.springframework.social.angel.api.AngelProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelAdapter implements ApiAdapter<Angel> {
    public boolean test(Angel angel) {
        try {
            angel.userOperations().getUserProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    public void setConnectionValues(Angel angelList, ConnectionValues values) {
        AngelProfile profile = angelList.userOperations().getUserProfile();
        values.setProviderUserId(Long.toString(profile.getId()));
        values.setDisplayName(profile.getName());
        values.setProfileUrl(profile.getAngellist_url());
        values.setImageUrl(profile.getImage());
    }

    public UserProfile fetchUserProfile(Angel angelList) {
        AngelProfile profile = angelList.userOperations().getUserProfile();
        return new UserProfileBuilder().setName(profile.getName()).setUsername(profile.getName()).build();
    }

    public void updateStatus(Angel angelList, String message) {};
}
