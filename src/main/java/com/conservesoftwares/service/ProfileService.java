package com.conservesoftwares.service;

import com.conservesoftwares.model.DetailedProfile;
import com.conservesoftwares.model.MinimalProfile;
import com.conservesoftwares.model.Profile;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Created by shailendra on 7/4/17.
 */

@Component
public class ProfileService {
    private final List<Profile> profiles;

    private final Path PROFILES_FILE = Paths.get(this.getClass().getResource("/profiles.json").toURI());

    public ProfileService() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        profiles = objectMapper.readValue(PROFILES_FILE.toFile(), new TypeReference<List<Profile>>() {
        });
    }


    protected Optional<Profile> get(String username) {
        return profiles.stream().filter(profile -> profile.getLogin().getUsername().equals(username)).findFirst();
    }

    public Optional<MinimalProfile> minimal(String username) {
        return get(username).map(profile -> new MinimalProfile(profile));
    }

    public Optional<DetailedProfile> details(String username) {
        return get(username).map(profile -> new DetailedProfile(profile));
    }

}
