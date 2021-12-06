package com.epam.spring.homework4.testing.controller.dto;

import com.epam.spring.homework4.testing.model.Question;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class TestDto {
    @Positive
    private Integer id;
    @NotBlank
    private String name;

    @NotBlank
    private String complexity;

    private int sumOfQuestions;

    @NotBlank
    private String status;

    private int result;

    private AccountDto account;

}
