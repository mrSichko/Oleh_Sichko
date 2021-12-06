package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto save(QuestionDto questionDto);

    List<QuestionDto> findAllByTestId(Integer testId);

    QuestionDto findByQuestionId(Integer id);

    void removeByQuestionId(Integer id);
}
