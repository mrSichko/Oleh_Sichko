package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.model.Answer;
import com.epam.spring.homework4.testing.model.Question;
import com.epam.spring.homework4.testing.repository.AnswerRepository;
import com.epam.spring.homework4.testing.service.mapper.AnswerMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerServiceImplTest {
    @InjectMocks
    private AnswerServiceImpl answerService;

    @Mock
    private AnswerRepository answerRepository;

    @Spy
    private AnswerMapper answerMapper = Mappers.getMapper(AnswerMapper.class);

    private static final int MOCK_ID = 1;

    @Test
    void saveTest() {
        //Given
        Answer answer = Answer.builder().id(MOCK_ID).build();
        when(answerRepository.save(answer)).thenReturn(answer);

        //When
        AnswerDto answerDto = answerService.save(answerMapper.mapAnswersDto(answer));

        //Then
        assertEquals(answer.getId(), answerDto.getId());
    }

    @Test
    void findAllByQuestionIdTest() {
        //Given
        List<Answer> answerList = List.of(Answer.builder().id(MOCK_ID).build());
        when(answerRepository.findAllByQuestionId(MOCK_ID)).thenReturn(answerList);

        //When
        List<AnswerDto> answerDtoList = answerService.findAllByQuestionId(MOCK_ID);

        //Then
        assertEquals(answerList.size(), answerDtoList.size());
    }

    @Test
    void findByIdTest() {
        //Given
        Answer answer = Answer.builder().id(MOCK_ID).build();
        when(answerRepository.findById(MOCK_ID)).thenReturn(Optional.of(answer));

        //When
        AnswerDto answerDto = answerService.findById(MOCK_ID);

        //Then
        assertEquals(answer.getId(), answerDto.getId());
    }

    @Test
    void removeByIdTest() {
        //Given
        doNothing().when(answerRepository).removeById(MOCK_ID);

        //When
        answerService.removeById(MOCK_ID);
        answerService.removeById(MOCK_ID);

        //Then
        verify(answerRepository, times(2)).removeById(MOCK_ID);
    }
}