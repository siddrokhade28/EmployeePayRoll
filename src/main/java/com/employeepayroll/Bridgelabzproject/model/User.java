package com.employeepayroll.Bridgelabzproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",joinColumns = {
            @JoinColumn(name = "user_id")
    },inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Roles> roles;
}
