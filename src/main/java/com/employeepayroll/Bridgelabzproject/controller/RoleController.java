package com.employeepayroll.Bridgelabzproject.controller;

import com.employeepayroll.Bridgelabzproject.model.Roles;
import com.employeepayroll.Bridgelabzproject.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Roles createNewRoles(@RequestBody Roles role){
        return roleService.createNewRole(role);
    }
}
