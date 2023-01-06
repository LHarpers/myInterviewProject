package com.my.interview.project.core.service;

import com.my.interview.project.core.exception.ConflictException;
import com.my.interview.project.core.domain.Employee;
import com.my.interview.project.core.exception.ForbiddenException;
import com.my.interview.project.core.exception.NotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee createNewEmployee(Employee employee) throws ConflictException, ForbiddenException;

    List<Employee> getAllEmployeesPaginated(Integer page, Integer pageSize);

    Employee updateEmployee(Employee employee) throws NotFoundException, ForbiddenException;
}
