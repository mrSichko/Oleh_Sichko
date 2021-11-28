package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@Builder
public class AccountDto {
    @NotBlank
    private String login;

    @Email
    private String email;

    @NotBlank
    private String password;

    @Min(1)
    @Max(2)
    private int roleId;

    @Min(1)
    @Max(2)
    private int languageId;
}
