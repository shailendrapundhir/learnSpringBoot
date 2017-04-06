package com.conservesoftwares.model;


/**
 * Created by shailendra on 7/4/17.
 */

public class DetailedProfile {
    private final String email;
    private final Name name;
    private final String username;
    private final Picture picture;

    public DetailedProfile(String email, Name name, String username, Picture picture) {
        this.email = email;
        this.name = name;
        this.username = username;
        this.picture = picture;
    }

    public DetailedProfile(Profile profile) {
        this.email = profile.getEmail();
        this.name = profile.getName();
        this.username = profile.getLogin().getUsername();
        this.picture = profile.getPicture();
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Picture getPicture() {
        return picture;
    }
}
