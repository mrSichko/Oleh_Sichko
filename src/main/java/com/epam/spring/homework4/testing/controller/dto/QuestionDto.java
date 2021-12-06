package com.epam.spring.homework4.testing.controller.dto;

import com.epam.spring.homework4.testing.model.Answer;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@Builder
public class QuestionDto {
    @Positive
    private Integer id;

    @NotBlank
    private String description;

    private TestDto test;
}
