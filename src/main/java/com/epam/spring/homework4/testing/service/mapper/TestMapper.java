package com.epam.spring.homework4.testing.service.mapper;

import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TestMapper {
    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    List<TestDto> mapTestDtoList(List<Test> testList);

    TestDto mapTestDto (Test test);

    Test mapTest (TestDto testDto);

}
