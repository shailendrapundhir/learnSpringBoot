package com.conservesoftwares.controller;

import com.conservesoftwares.exceptions.FailedToLoginException;
import com.conservesoftwares.model.LoginCredentials;
import com.conservesoftwares.model.MinimalProfile;
import com.conservesoftwares.service.JwtService;
import com.conservesoftwares.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by shailendra on 7/4/17.
 */

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    private final LoginService loginService;
    private final JwtService jwtService;

    @SuppressWarnings("unused")
    public LoginController() {
        this(null, null);
    }

    @Autowired
    public LoginController(LoginService loginService, JwtService jwtService) {
        this.loginService = loginService;
        this.jwtService = jwtService;
    }

    @RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE)
    public MinimalProfile login(@RequestBody LoginCredentials loginCredentials, HttpServletResponse response) {
        return loginService.login(loginCredentials).map(minimalProfile -> {
            try {
                response.setHeader("Token", jwtService.tokenFor(minimalProfile));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return minimalProfile;
        }).orElseThrow(() -> new FailedToLoginException(loginCredentials.getUsername()));
    }


}
