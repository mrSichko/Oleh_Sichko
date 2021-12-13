package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.config.TestWebConfig;
import com.epam.spring.homework4.testing.controller.dto.QuestionDto;
import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.service.QuestionService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = QuestionController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Import(TestWebConfig.class)
class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final int MOCK_ID = 36;
    private static final String MOCK_DESCRIPTION = "to be or not to be?";

    @Test
    void createQuestionTest() throws Exception {
        QuestionDto questionDto = QuestionDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).build();
        when(questionService.save(questionDto)).thenReturn(questionDto);

        mockMvc.perform(post("/account/test/question")
                        .content(mapper.writeValueAsString(questionDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void findTest() throws Exception {
        QuestionDto questionDto = QuestionDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).build();
        when(questionService.findByQuestionId(MOCK_ID)).thenReturn(questionDto);

        mockMvc.perform(get("/account/test/question/{questionId}", MOCK_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(questionDto.getId()));

    }

    @Test
    void findAllTestByTestIdTest() throws Exception {
        TestDto testDto = TestDto.builder()
                .id(MOCK_ID).name("name")
                .complexity("easy").status("new")
                .build();
        List<QuestionDto> testDtoList = List.of(QuestionDto.builder()
                .id(MOCK_ID).description(MOCK_DESCRIPTION).test(testDto).build());
        when(questionService.findAllByTestId(MOCK_ID)).thenReturn(testDtoList);

        mockMvc.perform(get("/account/test/all-questions/{testId}", testDto.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].description")
                        .value(testDtoList.get(0).getDescription()));
    }

    @Test
    void deleteQuestionTest() throws Exception {
        doNothing().when(questionService).removeByQuestionId(MOCK_ID);

        mockMvc.perform(delete("/account/test/question/{questionId}", MOCK_ID))
                .andExpect(status().isNoContent())
                .andDo(print());

        mockMvc.perform(delete("/account/test/question/{questionId}", MOCK_ID))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(questionService, times(2)).removeByQuestionId(MOCK_ID);
    }
}