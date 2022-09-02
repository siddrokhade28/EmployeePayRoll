package com.employeepayroll.Bridgelabzproject.controller;

import com.employeepayroll.Bridgelabzproject.Security.MyUserDetailsService;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthRequest;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthResponse;
import com.employeepayroll.Bridgelabzproject.service.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private MyUserDetailsService userDetailsService;


    @RequestMapping(value = "/authenticate" ,method = RequestMethod.POST)
    public AuthResponse createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception{
        return userDetailsService.createJwtToken(authRequest);
    }
}
