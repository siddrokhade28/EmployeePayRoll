package com.employeepayroll.Bridgelabzproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Roles {
    @Id
    private String roleName;
    private String roleDescription;
}
