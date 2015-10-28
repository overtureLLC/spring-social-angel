package org.springframework.social.angel.api.impl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ryo on 10/27/15.
 */
public class AngelStartUpRole extends AngelObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private final long id;
    private final String role;
    private final String title;
    private boolean confirmed;

    private Date createdAt;
    private String startedAt;
//    private Date endedAt;


    private AngelStartUp startUp;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public AngelStartUpRole(long id, String role, String title) {
        this.id = id;
        this.role = role;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getTitle() {
        return title;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public AngelStartUp getStartUp() {
        return startUp;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getStartedAt() {
        return startedAt;
    }
}
