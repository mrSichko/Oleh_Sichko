package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class AccountDetailsDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String university;
    private String speciality;
    private String group;
    private int accountId;
}
