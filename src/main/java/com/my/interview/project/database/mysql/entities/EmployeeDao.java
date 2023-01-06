package com.my.interview.project.database.mysql.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String firstSurname;

    @Column
    @NotNull
    private String secondSurname;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String otherNames;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    private String idType;

    @Column(unique = true)
    @NotNull
    private String idNumber;

    @Column(unique = true)
    @NotNull
    private String email;

    @Column
    @NotNull
    private Date entryDate;

    @Column
    @NotNull
    private String area;

    @Column
    @NotNull
    private String Status;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date recordDateTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date editionDateTime;


    public void updateDao(EmployeeDao employee){
        this.setIdType(employee.getIdType());
        this.setIdNumber(employee.getIdNumber());
        this.setRecordDateTime(employee.getRecordDateTime());
        this.setEditionDateTime(employee.getEditionDateTime());
    }
}
