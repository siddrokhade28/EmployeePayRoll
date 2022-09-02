package com.employeepayroll.Bridgelabzproject.repo;

import com.employeepayroll.Bridgelabzproject.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles,String> {
}
