package com.employeepayroll.Bridgelabzproject.service;

import com.employeepayroll.Bridgelabzproject.Exception.ExceptionMessage;
import com.employeepayroll.Bridgelabzproject.Utility.Response;
import com.employeepayroll.Bridgelabzproject.dto.Employeedto;
import com.employeepayroll.Bridgelabzproject.mapper.employeeMapper;
import com.employeepayroll.Bridgelabzproject.model.Employee;
import com.employeepayroll.Bridgelabzproject.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*
Service class Implementation
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private employeeMapper mapper;

    @Override
    public Response saveEmployee(Employeedto employeedto) {
        employeeRepo.findByEmail(employeedto.getEmail()).ifPresent(employee -> {
            throw new ExceptionMessage("Employee Payroll Email is Already Present ");
        });

        employeeRepo.save(mapper.DtotoModel(employeedto));
        return new Response("Employee Payroll Added", HttpStatus.OK);
    }


    @Override
    public List<Employee> getallemployee() {

        return employeeRepo.findAll();
    }

    @Override
    public Employee get(Integer id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Response delete(Integer id) {
        employeeRepo.deleteById(id);
        return new Response("the Employee data is been deleted",HttpStatus.OK);
    }

    @Override
    public Response updateEmployee(Employeedto employeedto, Integer id) {
        Employee oldData = null;
        employeeRepo.findByEmail(employeedto.getEmail()).ifPresent(employee -> {
            throw new ExceptionMessage("Employee Payroll Email is Already Present ");
        });
        Optional<Employee> optional = Optional.ofNullable(employeeRepo.findById(id).orElseThrow(() -> new ExceptionMessage("User with ID" + id + " Cannot Be Updated Because It's not Present in the Employee List")));
        if (optional.isPresent())
            oldData = optional.get();
        oldData.setName(employeedto.getName());
        oldData.setPhoneNumber(employeedto.getPhoneNumber());
        oldData.setEmail(employeedto.getEmail());
        oldData.setSalary(employeedto.getSalary());
         employeeRepo.save(oldData);
         return new Response("Employee of id"+id+" updated",HttpStatus.OK);

    }
}
