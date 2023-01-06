package com.my.interview.project.web.resources.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequestDto {

    @NotNull(message = "Id must not be null")
    private Long id;

    @NotNull(message = "First Surname must not be null")
    @Pattern(regexp = "^[A-Z ]{1,20}$", message = "First Surname should be with only capital alphabetical letters, " +
            " without accents, and the maximum length is 20 characters.")
    private String firstSurname;

    @NotNull(message = "Second Surname must not be null")
    @Pattern(regexp = "^[A-Z ]{1,20}$", message = "Second Surname should be with only capital alphabetical letters, " +
            " without accents, and the maximum length is 20 characters.")
    private String secondSurname;

    @NotNull(message = "First Name must not be null")
    @Pattern(regexp = "^[A-Z ]{1,20}$", message = "First Name should be with only capital alphabetical letters, " +
            " without accents, and the maximum length is 20 characters.")
    private String firstName;

    @Pattern(regexp = "^[A-Z ]{0,50}$", message = "Other Names should be with only capital letters, " +
            "A-Z, without accents, with spaces beetween names and the maximum length is 50 characters.")
    private String otherNames;

    @NotNull(message = "Country must not be null")
    @Pattern(regexp = "^COLOMBIA$|^UNITED STATES$",
            message = "Invalid country, it should be COLOMBIA or UNITED STATES (Only capital letters).")
    private String country;

    @NotNull(message = "Entry Date must not be null")
    @PastOrPresent(message = "Entry Date can't be on future")
    private Date entryDate;

    @NotNull(message = "Area must not be null")
    @Pattern(regexp = "^ADMINISTRATION$|^FINANCE$|^PURCHASING$|^INFRAESTRUCTURE$|^OPERATION$|^HUMAN TALENT$|^MISCELANEOUS SERVICES$",
            message = "Invalid area, should be Administration, Finance, Purchasing, Infraestructure, Operation, Human Talent or Miscelaneous Services.")
    private String area;

}
