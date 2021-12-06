package com.epam.spring.homework4.testing.service.mapper;

import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    List<QuestionDto> mapQuestionDtoList(List<Question> questionList);

    QuestionDto mapQuestionDto (Question question);

    Question mapQuestion (QuestionDto questionDto);
}
