package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.config.TestWebConfig;
import com.epam.spring.homework4.testing.controller.dto.AnswerDto;
import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.service.AnswerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = AnswerController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Import(TestWebConfig.class)
class AnswerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AnswerService answerService;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final int MOCK_ID = 1;
    private static final String MOCK_DESCRIPTION = "yes!!!";


    @Test
    void createQuestion() throws Exception {
        AnswerDto answerDto = AnswerDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).build();
        when(answerService.save(answerDto)).thenReturn(answerDto);

        mockMvc.perform(post("/account/test/question/answer")
                        .content(mapper.writeValueAsString(answerDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void findAnswer() throws Exception {
        AnswerDto answerDto = AnswerDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).build();
        when(answerService.findById(MOCK_ID)).thenReturn(answerDto);

        mockMvc.perform(get("/account/test/question/answer/{answerId}", MOCK_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value(answerDto.getDescription()));
    }

    @Test
    void findAllAnswerByQuestionId() throws Exception {
        QuestionDto questionDto = QuestionDto.builder()
                .id(MOCK_ID).description("description").build();
        List<AnswerDto> answerDtoList = List.of(AnswerDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).question(questionDto).build());
        when(answerService.findAllByQuestionId(questionDto.getId())).thenReturn(answerDtoList);

        mockMvc.perform(get("/account/test/question/all-answers/{answerId}", questionDto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].description")
                        .value(answerDtoList.get(0).getDescription()));
    }

    @Test
    void deleteAnswer() throws Exception {
        doNothing().when(answerService).removeById(MOCK_ID);

        mockMvc.perform(delete("/account/test/question/answer/{answerId}", MOCK_ID))
                .andExpect(status().isNoContent())
                .andDo(print());

        mockMvc.perform(delete("/account/test/question/answer/{answerId}", MOCK_ID))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(answerService, times(2)).removeById(MOCK_ID);
    }
}