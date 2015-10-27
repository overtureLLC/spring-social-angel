package org.springframework.social.angel.config.support;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.angel.api.Angel;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelApiHelper implements ApiHelper<Angel> {
    private final UsersConnectionRepository usersConnectionRepository;

    private final UserIdSource userIdSource;

    public AngelApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    public Angel getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for AngelList");
        }

        Connection<Angel> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Angel.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default AngelListTemplate instance.");
        }
        return connection != null ? connection.getApi() : null;
    }

    private final static Log logger = LogFactory.getLog(AngelApiHelper.class);
}
