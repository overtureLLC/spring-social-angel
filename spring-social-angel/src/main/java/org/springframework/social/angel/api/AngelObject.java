package org.springframework.social.angel.api;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all AngelList types.
 * Offers an extraData property for carrying any data in response from AngelList that won't be otherwise mapped to any properties of the subclass.
 * @author ryo hang
 */
public class AngelObject {
    private Map<String, Object> extraData;

    public AngelObject() {
        this.extraData = new HashMap<String, Object>();
    }

    /**
     * @return Any fields in response from AngelList that are otherwise not mapped to any properties.
     */
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    /**
     * {@link JsonAnySetter} hook. Called when an otherwise unmapped property is being processed during JSON deserialization.
     * @param key The property's key.
     * @param value The property's value.
     */
    protected void add(String key, Object value) {
        extraData.put(key, value);
    }

}
