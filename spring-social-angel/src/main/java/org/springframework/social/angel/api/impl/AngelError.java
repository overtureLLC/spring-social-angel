package org.springframework.social.angel.api.impl;

/**
 * Created by ryo on 10/27/15.
 */
public class AngelError {
    private final Integer code;

    private final String type;

    private final String message;

    private final Integer subcode;

    private final String userMessage;

    private final String userTitle;

    public AngelError(Integer code, String type, String message, Integer subcode, String userMessage, String userTitle) {
        this.code = code != null && code != 0 ? code : null;
        this.type = type;
        this.message = message;
        this.subcode = subcode;
        this.userMessage = userMessage;
        this.userTitle = userTitle;
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Integer getSubcode() {
        return subcode;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getUserTitle() {
        return userTitle;
    }
}
