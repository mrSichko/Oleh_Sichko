package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Builder
public class AnswerDto {
    @Positive
    private Integer id;
    @NotBlank
    private String description;
    @NotNull
    private byte isCorrect;

    private QuestionDto question;
}
