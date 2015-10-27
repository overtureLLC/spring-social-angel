package org.springframework.social.angel.config.xml;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.angel.config.support.AngelApiHelper;
import org.springframework.social.angel.connect.AngelConnectionFactory;
import org.springframework.social.angel.security.AngelAuthenticationService;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.security.provider.SocialAuthenticationService;

import java.util.Map;

/**
 * Created by ryo on 10/25/15.
 */
public class AngelConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

    public AngelConfigBeanDefinitionParser() {
        super(AngelConnectionFactory.class, AngelApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return AngelAuthenticationService.class;
    }

    @Override
    protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(AngelConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
        if (allAttributes.containsKey("app-namespace")) {
            builder.addConstructorArgValue(allAttributes.get("app-namespace"));
        }
        return builder.getBeanDefinition();
    }

}
