package com.codewithelshamy.spring.security.SpringSecurity;

import javax.naming.AuthenticationException;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationProvider;

public class MyAuthenticationProvider implements AuthenticationProvider {

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public org.springframework.security.core.Authentication authenticate(
            org.springframework.security.core.Authentication authentication)
            throws org.springframework.security.core.AuthenticationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

}
