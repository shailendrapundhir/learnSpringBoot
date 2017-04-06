package com.conservesoftwares.model;

import lombok.Data;

/**
 * Created by shailendra on 7/4/17.
 */

public class Profile {
    private Name name;
    private Login login;
    private String email;
    private Picture picture;

    public Profile() {

    }

    public Profile(Name name, Login login, String email, Picture picture) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
