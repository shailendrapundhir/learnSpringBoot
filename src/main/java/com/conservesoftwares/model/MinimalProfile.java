package com.conservesoftwares.model;

import lombok.Data;

import java.net.URL;

/**
 * Created by shailendra on 7/4/17.
 */

public class MinimalProfile {
    private final String username;
    private final Name name;
    private final URL thumbnail;

    public MinimalProfile(String username, Name name, URL thumbnail) {
        this.username = username;
        this.name = name;
        this.thumbnail = thumbnail;
    }

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
}
