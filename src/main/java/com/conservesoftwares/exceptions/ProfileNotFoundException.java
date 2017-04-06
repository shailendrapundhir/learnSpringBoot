package com.conservesoftwares.exceptions;

/**
 * Created by shailendra on 7/4/17.
 */
public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String username) {
        super("Profile with username " + username + "does not exist.");
    }
}
