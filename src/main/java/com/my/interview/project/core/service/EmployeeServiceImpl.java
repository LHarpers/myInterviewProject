package com.my.interview.project.core.service;

import com.my.interview.project.core.exception.ConflictException;
import com.my.interview.project.core.domain.Employee;
import com.my.interview.project.core.exception.ForbiddenException;
import com.my.interview.project.core.exception.NotFoundException;
import com.my.interview.project.database.mysql.entities.EmployeeDao;
import com.my.interview.project.database.mysql.repositories.EmployeeRepository;
import com.my.interview.project.core.mappers.EmployeeMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createNewEmployee(Employee employee) throws ConflictException, ForbiddenException {
        if (employeeRepository.existsByIdNumber(employee.getIdNumber())) {
            throw new ConflictException("This identification number already exists in database");
        }

        employee.setEmail(generateEmail(employee));

        return EmployeeMapper.MAPPER.daoToDomain(
                            employeeRepository.save(
                                    EmployeeMapper.MAPPER.domainToDao(employee)));
    }

    @Override
    public List<Employee> getAllEmployeesPaginated(Integer page, Integer pageSize){

        return employeeRepository.findAll(PageRequest.of(page, pageSize))
                .get()
                .map(EmployeeMapper.MAPPER::daoToDomain)
                .collect(Collectors.toList());

    }

    @Override
    public Employee updateEmployee(Employee employee) throws NotFoundException, ForbiddenException {

        Optional<EmployeeDao> oldEmployeeDao = employeeRepository.findById(employee.getId());

        if(oldEmployeeDao.isEmpty()){
            throw new NotFoundException("Employee not found in database for id: " + employee.getId());
        }

        Employee oldEmployee = EmployeeMapper.MAPPER.daoToDomain(oldEmployeeDao.get());

        if(!(employee.getFirstName().equals(oldEmployee.getFirstName()) &&
                employee.getFirstSurname().equals(oldEmployee.getFirstSurname())) ||
                    !employee.getCountry().equals(oldEmployee.getCountry())){

            employee.setEmail(generateEmail(employee));
        } else {
            employee.setEmail(oldEmployee.getEmail());
        }

        EmployeeDao updatedEmployeeDatabase = EmployeeMapper.MAPPER.domainToDao(employee);
        updatedEmployeeDatabase.updateDao(oldEmployeeDao.get());

        return EmployeeMapper.MAPPER.daoToDomain(
                employeeRepository.save(updatedEmployeeDatabase));

    }

    public String generateEmail(Employee employee) throws ForbiddenException {
        String emailPrefix = employee.getFirstName() + "." + employee.getFirstSurname();

        String emailSufix = employee.getCountry().equalsIgnoreCase("United States") ?
                "@CIDENET.COM.US" : "@CIDENET.COM.CO";

        if(employeeRepository.existsByEmail(emailPrefix + emailSufix)){
            EmployeeDao sameEmailEmployee = employeeRepository.getTopByFirstNameAndFirstSurnameAndCountryOrderByIdDesc(
                                                                                        employee.getFirstName(),
                                                                                        employee.getFirstSurname(),
                                                                                        employee.getCountry());

            String emailId = sameEmailEmployee.getEmail()
                    .replace(emailPrefix, "")
                    .replace(emailSufix, "");

            emailPrefix += 1 + Long.parseLong(emailId.isEmpty() ? "0" : emailId);
        }

        String newEmail = emailPrefix + emailSufix;

        if(newEmail.length() > 300){
            throw new ForbiddenException("Email could not be created because it has more than 300 characters: " + newEmail);
        }

        return newEmail;
    }

}
