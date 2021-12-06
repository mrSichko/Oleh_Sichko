package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.model.Answer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    AnswerDto save(AnswerDto answerDto);

    List<AnswerDto> findAllByQuestionId(Integer questionId);

    AnswerDto findById(Integer id);

    @Transactional
    void removeById(Integer id);
}
