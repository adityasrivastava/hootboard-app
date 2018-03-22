//package com.hootboard.auth.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
////@Component
//public class UserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
//        if (token.getCredentials() == null || userDetails.getPassword() == null) {
//            throw new BadCredentialsException("Credentials may not be null.");
//        }
//
//        if (!passwordEncoder.matches((String) token.getCredentials(), userDetails.getPassword())) {
//            throw new BadCredentialsException("Invalid credentials.");
//        }
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//
//        UserDetails userDetails = userDetailsService.loadUserByUsername(s);
//
//        return userDetails;
//    }
//}
