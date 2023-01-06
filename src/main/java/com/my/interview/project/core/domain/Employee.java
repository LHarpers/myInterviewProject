package com.my.interview.project.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;

    private String firstSurname;

    private String secondSurname;

    private String firstName;

    private String otherNames;

    private String country;

    private String idType;

    private String idNumber;

    private String email;

    private Date entryDate;

    private String area;

    private String status;
}
