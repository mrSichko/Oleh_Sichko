package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AccountDto {
    private String login;
    private String email;
    private int roleId;
    private int languageId;
}
