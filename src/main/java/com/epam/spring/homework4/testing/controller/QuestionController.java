package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.service.QuestionService;
import com.epam.spring.homework4.testing.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/account/test/question")
    public QuestionDto createQuestion(@RequestBody @Valid QuestionDto questionDto) {
        return questionService.save(questionDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/test/question/{questionId}")
    public QuestionDto find(@PathVariable Integer questionId) {
        return questionService.findByQuestionId(questionId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/test/all-questions/{testId}")
    public List<QuestionDto> findAllTestByTestId(@PathVariable Integer testId) {
        return questionService.findAllByTestId(testId);
    }


    @DeleteMapping(value = "/account/test/question/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer questionId) {
        questionService.removeByQuestionId(questionId);
        return ResponseEntity.noContent().build();
    }
}
