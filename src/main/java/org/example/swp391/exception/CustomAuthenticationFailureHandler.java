package org.example.swp391.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        System.out.println("Login attempt failed. Username: " + username);

        if (exception instanceof UsernameNotFoundException) {
            System.out.println("Reason: Username not found");
        } else if (exception instanceof BadCredentialsException) {
            System.out.println("Reason: Bad credentials (incorrect password)");
        } else {
            System.out.println("Reason: " + exception.getMessage());
        }

        response.sendRedirect("/login?error");
    }
}



