package com.epam.spring.homework4.testing.controller.dto;

import com.epam.spring.homework4.testing.model.Language;
import com.epam.spring.homework4.testing.model.Test;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class AccountDto {
    @NotBlank
    private String login;

    @Email
    private String email;

    @NotBlank
    private String password;

    private RoleDto role;

    private LanguageDto language;
}
