package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.exception.EntityNotFoundException;
import com.epam.spring.homework4.testing.model.Answer;
import com.epam.spring.homework4.testing.repository.AnswerRepository;
import com.epam.spring.homework4.testing.service.AnswerService;
import com.epam.spring.homework4.testing.service.mapper.AnswerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    @Override
    public AnswerDto save(AnswerDto answerDto) {
        log.info("Save answer with id - " + answerDto.getId());
        Answer answer = AnswerMapper.INSTANCE.mapAnswer(answerDto);
        answerRepository.save(answer);
        return AnswerMapper.INSTANCE.mapAnswersDto(answer);
    }

    @Override
    public List<AnswerDto> findAllByQuestionId(Integer questionId) {
        log.info("Find all answers by question id - " + questionId);
        List<Answer> answerList = answerRepository.findAllByQuestionId(questionId);
        return AnswerMapper.INSTANCE.mapAnswerDtoList(answerList);
    }

    @Override
    public AnswerDto findById(Integer id) {
        log.info("Find answer by id - " + id);
        try {
            Answer answer = answerRepository.findById(id).get();
            return AnswerMapper.INSTANCE.mapAnswersDto(answer);
        } catch (NoSuchElementException ex) {
            log.error(ex.getMessage(), ex);
            throw new EntityNotFoundException("Answer not found");
        }
    }

    @Override
    public void removeById(Integer id) {
        log.info("Remove answer by id - " + id);
        answerRepository.removeById(id);
    }
}
