package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {

    private Integer id;
    private String description;
    private boolean isCorrect;
    private int questionId;
}
