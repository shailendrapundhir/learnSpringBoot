package com.conservesoftwares.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Created by shailendra on 7/4/17.
 */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType(APPLICATION_JSON_VALUE);

        String message;
        if(e.getMessage()!=null){
            message = e.getCause().getMessage();
        }else {
            message = e.getMessage();
        }

        byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error",message));
        httpServletResponse.getOutputStream().write(body);
    }
}
