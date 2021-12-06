package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
public class AccountDetailsDto {
    @Positive
    private Integer id;

    private String firstName;

    private String lastName;

    private Timestamp dateOfBirth;

    private String university;

    private String speciality;

    @Positive
    private int accountId;
}
