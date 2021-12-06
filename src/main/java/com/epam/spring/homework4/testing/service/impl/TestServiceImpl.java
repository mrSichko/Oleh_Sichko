package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.model.Test;
import com.epam.spring.homework4.testing.repository.TestRepository;
import com.epam.spring.homework4.testing.service.TestService;
import com.epam.spring.homework4.testing.service.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Override
    public TestDto save(TestDto testDto) {
        log.info("save test with name - " + testDto.getName());
        Test test = TestMapper.INSTANCE.mapTest(testDto);
        test.setCreateTime(Timestamp.from(Instant.now()));
        testRepository.save(test);
        return TestMapper.INSTANCE.mapTestDto(test);
    }

    @Override
    public TestDto findByName(String name) {
        log.info("find test by name - " + name);
        Test test = testRepository.findByName(name);
        return TestMapper.INSTANCE.mapTestDto(test);
    }

    @Override
    public List<TestDto> findAll() {
        log.info("find all tests");
        return TestMapper.INSTANCE.mapTestDtoList(testRepository.findAll());
    }

    @Override
    public void removeByName(String name) {
        log.info("delete test by name - " + name);
        testRepository.removeByName(name);
    }
}
