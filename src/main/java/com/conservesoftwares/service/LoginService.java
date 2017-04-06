package com.conservesoftwares.service;

import com.conservesoftwares.model.LoginCredentials;
import com.conservesoftwares.model.MinimalProfile;
import com.conservesoftwares.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Optional;

/**
 * Created by shailendra on 7/4/17.
 */

@Component
public class LoginService {

    private ProfileService profileService;

    @SuppressWarnings("unused")
    public LoginService() {
        this(null);
    }

    @Autowired
    public LoginService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public Optional<MinimalProfile> login(LoginCredentials loginCredentials){
        return profileService.get(loginCredentials.getUsername())
                .filter(profile -> profile.getLogin().getPassword().equals(loginCredentials.getPassword()))
                .map(profile -> new MinimalProfile(profile));
    }
}
