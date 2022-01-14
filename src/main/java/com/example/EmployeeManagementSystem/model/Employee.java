package com.example.EmployeeManagementSystem.model;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="department")
    private String department;
    @Column(name="phone")
    private String phone;
    @Column(name="date_of_birth")
    private Date dateOfBirth;
}
