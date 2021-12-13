package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/account/")
@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/test")
    public TestDto createTest(@RequestBody @Valid TestDto testDto) {
        return testService.save(testDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/test/{name}")
    public TestDto find(@PathVariable String name) {
        return testService.findByName(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/test")
    public List<TestDto> findAll() {
        return testService.findAll();
    }


    @DeleteMapping(value = "/test/{name}")
    public ResponseEntity<Void> deleteTest(@PathVariable String name) {
        testService.removeByName(name);
        return ResponseEntity.noContent().build();
    }
}
