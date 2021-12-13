package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.repository.TestRepository;
import com.epam.spring.homework4.testing.service.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {
    @InjectMocks
    private TestServiceImpl testService;

    @Mock
    private TestRepository testRepository;

    @Spy
    private TestMapper testMapper = Mappers.getMapper(TestMapper.class);

    private static final int MOCK_ID = 1;
    private static final String MOCK_NAME = "Easy Test";

    @Test
    void saveTest() {
        //Given
        com.epam.spring.homework4.testing.model.Test test =
                com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).build();
        when(testRepository.save(test)).thenReturn(test);

        //When
        TestDto testDto = testService.save(testMapper.mapTestDto(test));

        //Then
        assertEquals(test.getId(), testDto.getId());
    }

    @Test
    void findByNameTest() {
        //Given
        com.epam.spring.homework4.testing.model.Test test =
                com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).name(MOCK_NAME).build();
        when(testRepository.findByName(MOCK_NAME)).thenReturn(test);

        //When
        TestDto testDto = testService.findByName(test.getName());

        //Then
        assertEquals(test.getName(), testDto.getName());
    }

    @Test
    void findAllTest() {
        //Given
        List<com.epam.spring.homework4.testing.model.Test> testList = List.of(com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).build());
        com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).build();
        when(testRepository.findAll()).thenReturn(testList);

        //When
        List<TestDto> testDtoList = testService.findAll();

        // Then
        assertEquals(testList.size(), testDtoList.size());
    }

    @Test
    void removeByNameTest() {
        //Given
        com.epam.spring.homework4.testing.model.Test test =
                com.epam.spring.homework4.testing.model.Test.builder().id(MOCK_ID).name(MOCK_NAME).build();
        doNothing().when(testRepository).removeByName(MOCK_NAME);

        //When
        testService.removeByName(MOCK_NAME);
        testService.removeByName(MOCK_NAME);

        //Then
        verify(testRepository, times(2)).removeByName(MOCK_NAME);
    }
}