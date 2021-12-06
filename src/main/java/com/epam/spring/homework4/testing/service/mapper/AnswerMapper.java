package com.epam.spring.homework4.testing.service.mapper;

import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    List<AnswerDto> mapAnswerDtoList(List<Answer> answerList);

    AnswerDto mapAnswersDto(Answer answer);

    Answer mapAnswer(AnswerDto answerDto);
}
