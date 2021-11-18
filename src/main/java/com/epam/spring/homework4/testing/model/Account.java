package com.epam.spring.homework4.testing.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Account {

    private String login;
    private String email;
    private String password;
    private Timestamp createTime;
    private int roleId;
    private int languageId;
}
