package com.employeepayroll.Bridgelabzproject.controller;

import com.employeepayroll.Bridgelabzproject.model.User;
import com.employeepayroll.Bridgelabzproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserContoller {
    @Autowired
    UserService userService;

    @PostConstruct
    public void initRolesAndUser(){
        userService.initRolesAndUser();
    }


    @PostMapping("/registerNewUser")
    public User registerNewUser(User user){
       return userService.registerNewUser(user);
    }

    @GetMapping("/foradmin")
    @PreAuthorize("hasRole(Admin)")
    public String forAdmin(){

        return "this for only admin";
    }
    @GetMapping("/foruser")
    @PreAuthorize("hasRole(User)")
    public String forUser(){

        return "this for only user";
    }

     /*
    if user has more than one role
    @PreAuthorize("hasAnyRole('Amin','User')")
     */

}
