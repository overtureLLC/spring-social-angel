package org.springframework.social.angel.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.angel.api.Angel;
import org.springframework.social.angel.api.RoleOperations;
import org.springframework.social.angel.api.StartUpOperations;
import org.springframework.social.angel.api.impl.serial.AngelModule;
import org.springframework.social.angel.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelTemplate extends AbstractOAuth2ApiBinding implements Angel {

    private String appId;
    private String applicationNamespace;

    private UserOperations userOperations;
    private RoleOperations roleOperations;
    private StartUpOperations startUpOperations;
    private RestOperations restOperations;


    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    public RoleOperations roleOperations() {
        return roleOperations;
    }

    @Override
    public StartUpOperations startupOperations() {
        return startUpOperations;
    }

    @Override
    public RestOperations restOperations() {
        return restOperations;
    }

    /**
     * Create a new instance of FacebookTemplate.
     * This constructor creates the FacebookTemplate using a given access token.
     * @param accessToken An access token given by Facebook after a successful OAuth 2 authentication (or through Facebook's JS library).
     */
    public AngelTemplate(String accessToken) {
        this(accessToken, null);
    }

    public AngelTemplate(String accessToken, String applicationNamespace) {
        this(accessToken, applicationNamespace, null);
    }

    public AngelTemplate(String accessToken, String applicationNamespace, String appId) {
        super(accessToken);
        this.applicationNamespace = applicationNamespace;
        this.appId = appId;
        initialize();
    }

    // AbstractOAuth1ApiBinding hooks

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        converter.setObjectMapper(new ObjectMapper().registerModule(new AngelModule()));
        return converter;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new AngelErrorHandler());
    }



    @Override
    public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
    }

    // private helpers
    private void initialize() {
        // Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
        super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
        initSubApis();
    }

    private void initSubApis() {
        userOperations = new UserTemplate(this,getRestTemplate());
        roleOperations = new RoleTemplate(this,getRestTemplate());
        startUpOperations = new StartUpTemplate(this,getRestTemplate());
    }


    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(Angel.API_URL + path).queryParams(parameters).build();
    }

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}
