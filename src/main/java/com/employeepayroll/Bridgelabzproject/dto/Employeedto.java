package com.employeepayroll.Bridgelabzproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

/*
Dto Class to manage the output of the Api Calls
 */
@Setter
@Getter
public class Employeedto {
    @Id
    private int id;
    private String name;
    private String email;
    private int PhoneNumber;
    private int salary;
}
