package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.angel.api.AngelProfile;

/**
 * Created by ryo on 10/27/15.
 */
public class AngelModule extends SimpleModule {

    public AngelModule() {
        super("AngelModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(AngelProfile.class, AngelProfileMixin.class);
    }
}
