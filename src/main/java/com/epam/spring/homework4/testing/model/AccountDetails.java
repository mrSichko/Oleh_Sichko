package com.epam.spring.homework4.testing.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "account_details")
@Data
@Builder
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String university;
    private String speciality;
    private String group;
    private int accountId;
}
