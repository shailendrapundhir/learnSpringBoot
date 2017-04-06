package com.conservesoftwares.service;

import com.conservesoftwares.config.SecretKeyProvider;
import com.conservesoftwares.model.MinimalProfile;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneOffset.UTC;

/**
 * Created by shailendra on 7/4/17.
 */

@Component
public class JwtService {
    private static final String ISSUER = "com.conservesoftwares";
    private SecretKeyProvider secretKeyProvider;

    @SuppressWarnings("unused")
    public JwtService(){
        this(null);
    }

    @Autowired
    public JwtService(SecretKeyProvider secretKeyProvider){
        this.secretKeyProvider = secretKeyProvider;
    }

    public String tokenFor(MinimalProfile minimalProfile) throws IOException,URISyntaxException {
        byte[] secretKey = secretKeyProvider.getKey();

        Date expiration = Date.from(LocalDateTime.now().plusHours(2).toInstant(UTC));
        return Jwts.builder()
                .setSubject(minimalProfile.getUsername())
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .compact();
    }
}
