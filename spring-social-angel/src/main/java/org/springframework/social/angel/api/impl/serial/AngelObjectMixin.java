package org.springframework.social.angel.api.impl.serial;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ryo on 10/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AngelObjectMixin {
    @JsonAnySetter
    abstract void add(String key, Object value);
}
