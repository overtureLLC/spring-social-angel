package org.springframework.social.angel.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.DuplicateStatusException;
import org.springframework.social.ExpiredAuthorizationException;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.RevokedAuthorizationException;
import org.springframework.social.ServerException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.web.client.DefaultResponseErrorHandler;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.social.angel.api.AngelErrors.*;
/**
 * Subclass of {@link DefaultResponseErrorHandler} that handles errors from AngelList's
 * API, interpreting them into appropriate exceptions.
 * @author Ryo Hang
 */
class AngelErrorHandler extends DefaultResponseErrorHandler {

    private static final String PROVIDER_ID = "angellist";
    private final static Log logger = LogFactory.getLog(AngelErrorHandler.class);

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        AngelError error = extractErrorFromResponse(response);
        handleAngelError(response.getStatusCode(), error);
    }

    /**
     * Examines the error data returned from AngelList and throws the most applicable exception.
     * @param errorDetails a Map containing a "type" and a "message" corresponding to the API's error response structure.
     */
    void handleAngelError(HttpStatus statusCode, AngelError error) {
        if (error != null && error.getCode() != null) {
            int code = error.getCode();

            if (code == UNKNOWN) {
                throw new UncategorizedApiException(PROVIDER_ID, error.getMessage(), null);
            } else if (code == SERVICE) {
                throw new ServerException(PROVIDER_ID, error.getMessage());
            } else if (code == TOO_MANY_CALLS || code == USER_TOO_MANY_CALLS || code == EDIT_FEED_TOO_MANY_USER_CALLS || code == EDIT_FEED_TOO_MANY_USER_ACTION_CALLS) {
                throw new RateLimitExceededException(PROVIDER_ID);
            } else if (code == PERMISSION_DENIED || isUserPermissionError(code)) {
                throw new InsufficientPermissionException(PROVIDER_ID);
            } else if (code == PARAM_SESSION_KEY || code == PARAM_SIGNATURE) {
                throw new InvalidAuthorizationException(PROVIDER_ID, error.getMessage());
            } else if (code == PARAM_ACCESS_TOKEN && error.getSubcode() == null) {
                throw new InvalidAuthorizationException(PROVIDER_ID, error.getMessage());
            } else if (code == PARAM_ACCESS_TOKEN && error.getSubcode() == 463) {
                throw new ExpiredAuthorizationException(PROVIDER_ID);
            } else if (code == PARAM_ACCESS_TOKEN) {
                throw new RevokedAuthorizationException(PROVIDER_ID, error.getMessage());
            } else if (code == MESG_DUPLICATE) {
                throw new DuplicateStatusException(PROVIDER_ID, error.getMessage());
            } else if (code == DATA_OBJECT_NOT_FOUND || code == PATH_UNKNOWN) {
                throw new ResourceNotFoundException(PROVIDER_ID, error.getMessage());
            } else {
                throw new UncategorizedApiException(PROVIDER_ID, error.getMessage(), null);
            }
        }

    }

    private AngelError extractErrorFromResponse(ClientHttpResponse response) throws IOException {
        String json = readResponseJson(response);
        try {
            ObjectMapper mapper = new ObjectMapper(new JsonFactory());
            JsonNode jsonNode = mapper.readValue(json, JsonNode.class);
            if (jsonNode.has("error")) {
                JsonNode errorNode = jsonNode.get("error");
                Integer code = errorNode.has("code") ? errorNode.get("code").intValue() : null;
                String type = errorNode.has("type") ? errorNode.get("type").asText() : null;
                String message = errorNode.has("message") ? errorNode.get("message").asText() : null;
                Integer subcode = errorNode.has("error_subcode") ? errorNode.get("error_subcode").intValue() : null;
                String userMessage = errorNode.has("error_user_msg") ? errorNode.get("error_user_msg").asText() : null;
                String userTitle = errorNode.has("error_user_title") ? errorNode.get("error_user_title").asText() : null;

                AngelError error = new AngelError(code, type, message, subcode, userMessage, userTitle);
                if (logger.isDebugEnabled()) {
                    logger.debug("AngelList error: ");
                    logger.debug("   CODE        : " + error.getCode());
                    logger.debug("   TYPE        : " + error.getType());
                    logger.debug("   SUBCODE     : " + error.getSubcode());
                    logger.debug("   MESSAGE     : " + error.getMessage());
                    logger.debug("   USER TITLE  : " + error.getUserTitle());
                    logger.debug("   USER MESSAGE: " + error.getUserMessage());
                }
                return error;
            }
        } catch (JsonParseException e) {
            return null;
        }
        return null;
    }

    private String readResponseJson(ClientHttpResponse response) throws IOException {
        String json = readFully(response.getBody());
        if (logger.isDebugEnabled()) {
            logger.debug("Error from AngelList: " + json);
        }
        return json;
    }

    private String readFully(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            sb.append(reader.readLine());
        }
        return sb.toString();
    }
}