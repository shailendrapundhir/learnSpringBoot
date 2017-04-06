package com.conservesoftwares.model;

import lombok.Data;

import java.net.URL;

/**
 * Created by shailendra on 7/4/17.
 */

public class Picture {
    private URL large;
    private URL medium;
    private URL thumbnail;

    public Picture() {
    }

    public Picture(URL large, URL medium, URL thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public URL getLarge() {
        return large;
    }

    public void setLarge(URL large) {
        this.large = large;
    }

    public URL getMedium() {
        return medium;
    }

    public void setMedium(URL medium) {
        this.medium = medium;
    }

    public URL getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(URL thumbnail) {
        this.thumbnail = thumbnail;
    }
}
