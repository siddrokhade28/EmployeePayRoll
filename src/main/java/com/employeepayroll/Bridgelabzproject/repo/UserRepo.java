package com.employeepayroll.Bridgelabzproject.repo;

import com.employeepayroll.Bridgelabzproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String > {
}
