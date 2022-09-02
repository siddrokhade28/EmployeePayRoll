package com.employeepayroll.Bridgelabzproject.mapper;

import com.employeepayroll.Bridgelabzproject.dto.Employeedto;
import com.employeepayroll.Bridgelabzproject.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/*
mapper class to use MapStruct
 */
@Mapper(componentModel = "spring")
public interface employeeMapper {

    Employeedto modelToDto(Employee employee);

    List<Employeedto> modelsToDtos(List<Employee> employeePayrolls);

    List<Employee> dtoToModels(List<Employeedto> employeePayrollDtos);

    Employee DtotoModel(Employeedto employeedto);


}
