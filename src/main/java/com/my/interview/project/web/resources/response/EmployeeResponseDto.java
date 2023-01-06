package com.my.interview.project.web.resources.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

    private Long id;

    private String firstName;

    private String secondSurname;

    private String firstSurname;

    private String otherNames;

    private String country;

    private Date entryDate;

    private String area;

    private String email;

    private String status;

}
