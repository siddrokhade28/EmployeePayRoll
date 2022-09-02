package com.employeepayroll.Bridgelabzproject.service;

import com.employeepayroll.Bridgelabzproject.model.Roles;
import com.employeepayroll.Bridgelabzproject.repo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;


@Service
public class RoleService {

    @Autowired
    private RolesRepo rolesRepo;

    public Roles createNewRole(Roles roles){
        return rolesRepo.save(roles);
    }

}
