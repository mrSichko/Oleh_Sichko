package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.model.Question;
import com.epam.spring.homework4.testing.repository.QuestionRepository;
import com.epam.spring.homework4.testing.service.mapper.QuestionMapper;
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
class QuestionServiceImplTest {
    @InjectMocks
    private QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;

    @Spy
    private QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);

    private static final int MOCK_ID = 1;

    @Test
    void saveTest() {
        //Given
        Question question = Question.builder().id(MOCK_ID).build();
        when(questionRepository.save(question)).thenReturn(question);

        //When
        QuestionDto questionDto = questionService.save(questionMapper.mapQuestionDto(question));

        //Then
        assertEquals(question.getId(), questionDto.getId());
    }

    @Test
    void findByQuestionIdTest() {
        //Given
        Question question = Question.builder().id(MOCK_ID).build();
        when(questionRepository.findById(MOCK_ID)).thenReturn(Optional.of(question));

        //When
        QuestionDto questionDto = questionService.findByQuestionId(MOCK_ID);

        //Then
        assertEquals(question.getId(), questionDto.getId());
    }

    @Test
    void findAllByTestIdTest() {
        //Given

        com.epam.spring.homework4.testing.model.Test test =
                com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).build();
        List<Question> questionList = List.of(Question.builder().id(MOCK_ID).test(test).build());
        when(questionRepository.findAllByTestId(MOCK_ID)).thenReturn(questionList);

        //When
        List<QuestionDto> questionDtoList = questionService.findAllByTestId(MOCK_ID);

        //Then
        assertEquals(questionList.size(), questionDtoList.size());
    }

    @Test
    void removeByQuestionIdTest() {
        //Given
        doNothing().when(questionRepository).removeById(MOCK_ID);

        //When
        questionService.removeByQuestionId(MOCK_ID);
        questionService.removeByQuestionId(MOCK_ID);

        //Then
        verify(questionRepository, times(2)).removeById(MOCK_ID);
    }
}