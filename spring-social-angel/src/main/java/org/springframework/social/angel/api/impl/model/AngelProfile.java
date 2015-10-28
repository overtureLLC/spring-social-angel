package org.springframework.social.angel.api.impl.model;

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing a AngelList user's profile information.
 *
 * @author ryo hang
 */
public class AngelProfile extends AngelObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final long id;
    private final String image;
    private final String bio;
    private String blogUrl;
    private String onlineBioUrl;
    private String twitterUrl;
    private String facebookUrl;
    private String linkedinUrl;
    private String angellistUrl;
    private int followerCount;
    private boolean investor;
    private List roles;
    private List locations;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public AngelProfile(long id, String name, String image,String bio) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.bio = bio;
    }
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getBio() {
        return bio;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public String getOnlineBioUrl() {
        return onlineBioUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public String getAngellistUrl() {
        return angellistUrl;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public boolean isInvestor() {
        return investor;
    }


    public List getRoles() {
        return roles;
    }

    public List getLocations() {
        return locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AngelProfile that = (AngelProfile) o;

        if (name != that.name) {
            return false;
        }
        if (id != that.id) {
            return false;
        }
        if (image != that.image) {
            return false;
        }
        if (bio != that.bio) {
            return false;
        }
        if (blogUrl != that.blogUrl) {
            return false;
        }
        if (onlineBioUrl != that.onlineBioUrl) {
            return false;
        }
        if (twitterUrl != that.twitterUrl) {
            return false;
        }
        if (facebookUrl != that.facebookUrl) {
            return false;
        }
        if (linkedinUrl != that.linkedinUrl) {
            return false;
        }
        if (angellistUrl != that.angellistUrl) {
            return false;
        }
        if (followerCount != that.followerCount) {
            return false;
        }
        if (investor != that.investor) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (blogUrl != null ? blogUrl.hashCode() : 0);
        result = 31 * result + (onlineBioUrl != null ? onlineBioUrl.hashCode() : 0);
        result = 31 * result + (twitterUrl != null ? twitterUrl.hashCode() : 0);
        result = 31 * result + (facebookUrl != null ? facebookUrl.hashCode() : 0);
        result = 31 * result + (linkedinUrl != null ? linkedinUrl.hashCode() : 0);
        result = 31 * result + (angellistUrl != null ? angellistUrl.hashCode() : 0);

        result = 31 * result + followerCount;

        result = 31 * result + (investor ? 1 : 0);
        return result;
    }

}
