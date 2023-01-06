package com.my.interview.project.database.mysql.repositories;

import com.my.interview.project.database.mysql.entities.EmployeeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDao,Long> {

    boolean existsByIdNumber(String idNumber);

    boolean existsByEmail(String email);

    EmployeeDao getTopByFirstNameAndFirstSurnameAndCountryOrderByIdDesc(String firstName, String firstSurname, String country);
}
