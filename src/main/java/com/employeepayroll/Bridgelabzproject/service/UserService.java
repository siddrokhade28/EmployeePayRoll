package com.employeepayroll.Bridgelabzproject.service;

import com.employeepayroll.Bridgelabzproject.model.Roles;
import com.employeepayroll.Bridgelabzproject.model.User;
import com.employeepayroll.Bridgelabzproject.repo.RolesRepo;
import com.employeepayroll.Bridgelabzproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        Roles roles=rolesRepo.findById("User").get();
        List<Roles> role=  new ArrayList<>();
        role.add(roles);
        user.setRoles(role);
        user.setPassword(getEncodedPassword(user.getPassword()));
       return userRepo.save(user);
    }

    public void initRolesAndUser(){
        Roles adminRole = new Roles();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        rolesRepo.save(adminRole);

        Roles userRole = new Roles();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        rolesRepo.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        List<Roles> adminRoles = new ArrayList<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userRepo.save(adminUser);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
