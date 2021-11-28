package com.epam.spring.homework4.testing.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    private Integer id;
    private String description;
    private int testId;
}
