package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/account/test/question/answer")
    public AnswerDto createQuestion(@RequestBody @Valid AnswerDto answerDto) {
        return answerService.save(answerDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/test/question/answer/{answerId}")
    public AnswerDto findAnswer(@PathVariable Integer answerId) {
        return answerService.findById(answerId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/test/question/all-answers/{answerId}")
    public List<AnswerDto> findAllAnswerByQuestionId(@PathVariable Integer answerId) {
        return answerService.findAllByQuestionId(answerId);
    }

    @DeleteMapping(value = "/account/test/question/answer/{answerId}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Integer answerId) {
        answerService.removeById(answerId);
        return ResponseEntity.noContent().build();
    }
}
