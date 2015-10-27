package org.springframework.social.angel.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String blog_url;
    private String online_bio_url;
    private String twitter_url;
    private String facebook_url;
    private String linkedin_url;
    private String angellist_url;
    private int follower_count;
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
    public String getBlog_url() {
        return blog_url;
    }

    public String getOnline_bio_url() {
        return online_bio_url;
    }

     public String getTwitter_url() {
        return twitter_url;
    }

    public String getFacebook_url() {
        return facebook_url;
    }


    public String getLinkedin_url() {
        return linkedin_url;
    }

    public String getAngellist_url() {
        return angellist_url;
    }

    public int getFollower_count() {
        return follower_count;
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
        if (blog_url != that.blog_url) {
            return false;
        }
        if (online_bio_url != that.online_bio_url) {
            return false;
        }
        if (twitter_url != that.twitter_url) {
            return false;
        }
        if (facebook_url != that.facebook_url) {
            return false;
        }
        if (linkedin_url != that.linkedin_url) {
            return false;
        }
        if (angellist_url != that.angellist_url) {
            return false;
        }
        if (follower_count != that.follower_count) {
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
        result = 31 * result + (blog_url != null ? blog_url.hashCode() : 0);
        result = 31 * result + (online_bio_url != null ? online_bio_url.hashCode() : 0);
        result = 31 * result + (twitter_url != null ? twitter_url.hashCode() : 0);
        result = 31 * result + (facebook_url != null ? facebook_url.hashCode() : 0);
        result = 31 * result + (linkedin_url != null ? linkedin_url.hashCode() : 0);
        result = 31 * result + (angellist_url != null ? angellist_url.hashCode() : 0);

        result = 31 * result + follower_count;

        result = 31 * result + (investor ? 1 : 0);
        return result;
    }

}
