package com.employeepayroll.Bridgelabzproject.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*
Model class for the project
 */
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int salary;
    private int PhoneNumber;
}
