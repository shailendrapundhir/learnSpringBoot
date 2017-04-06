package com.conservesoftwares.exceptions;


import org.springframework.security.core.AuthenticationException;

/**
 * Created by shailendra on 7/4/17.
 */
public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String s,Throwable t) {
        super(s,t);
    }
}
