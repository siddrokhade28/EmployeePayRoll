package com.employeepayroll.Bridgelabzproject.repo;


import com.employeepayroll.Bridgelabzproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
Repository class
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);

}
