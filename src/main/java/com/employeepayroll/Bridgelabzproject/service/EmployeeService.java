package com.employeepayroll.Bridgelabzproject.service;

import com.employeepayroll.Bridgelabzproject.Utility.Response;
import com.employeepayroll.Bridgelabzproject.dto.Employeedto;
import com.employeepayroll.Bridgelabzproject.model.Employee;

import java.util.List;

/*
Interface to manage methods for service class
 */
public interface EmployeeService {
    public Response saveEmployee(Employeedto employeedto);

    public List<Employee> getallemployee();

    public Employee get(Integer id);

    public Response delete(Integer id);

    Response updateEmployee(Employeedto employeedto, Integer id);
}
