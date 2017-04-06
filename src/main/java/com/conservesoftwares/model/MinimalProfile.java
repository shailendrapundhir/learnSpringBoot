package com.conservesoftwares.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import java.net.URL;

/**
 * Created by shailendra on 7/4/17.
 */

@Data
public class MinimalProfile {
    private String username;
    private Name name;
    private URL thumbnail;

    public MinimalProfile(Profile profile) {
        this.username = profile.getLogin().getUsername();
        this.name = profile.getName();
        this.thumbnail = profile.getPicture().getThumbnail();
    }

    public String getUsername() {
        return username;
    }

    public Name getName() {
        return name;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }
}
