package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.model.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TestService {
    TestDto save(TestDto testDto);

    TestDto findByName(String name);

    List<TestDto> findAll();

    void removeByName(String name);

}
