package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.exception.EntityNotFoundException;
import com.epam.spring.homework4.testing.model.Question;
import com.epam.spring.homework4.testing.repository.QuestionRepository;
import com.epam.spring.homework4.testing.service.QuestionService;
import com.epam.spring.homework4.testing.service.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public QuestionDto save(QuestionDto questionDto) {
        log.info("save question with id - " + questionDto.getId());
        Question question = QuestionMapper.INSTANCE.mapQuestion(questionDto);
        questionRepository.save(question);
        return QuestionMapper.INSTANCE.mapQuestionDto(question);
    }

    @Override
    public QuestionDto findByQuestionId(Integer id) {
        log.info("find question by id");
        try {
            Question question = questionRepository.findById(id).get();
            return QuestionMapper.INSTANCE.mapQuestionDto(question);
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            throw new EntityNotFoundException("Question not found");
        }
    }

    @Override
    public List<QuestionDto> findAllByTestId(Integer testId) {
        log.info("find all questions by test id - " + testId);
        List<Question> questionList = questionRepository.findAllByTestId(testId);
        return QuestionMapper.INSTANCE.mapQuestionDtoList(questionList);
    }

    @Override
    public void removeByQuestionId(Integer id) {
        log.info("remove question by question id - " + id);
        questionRepository.removeById(id);
    }
}
