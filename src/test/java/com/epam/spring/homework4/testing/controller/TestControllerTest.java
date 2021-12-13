package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.config.TestWebConfig;
import com.epam.spring.homework4.testing.controller.dto.TestDto;
import com.epam.spring.homework4.testing.service.TestService;
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

@WebMvcTest(value = TestController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Import(TestWebConfig.class)
class TestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TestService testService;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final int MOCK_ID = 1;
    private static final String MOCK_NAME = "my test";
    private static final String MOCK_STATUS = "new";
    private static final String MOCK_COMPLEXITY = "easy";


    @Test
    void createTest() throws Exception {
        TestDto testDto = TestDto.builder()
                .id(MOCK_ID).name(MOCK_NAME)
                .complexity(MOCK_COMPLEXITY).status(MOCK_STATUS)
                .build();
        when(testService.save(testDto)).thenReturn(testDto);

        mockMvc.perform(post("/account/test")
                        .content(mapper.writeValueAsString(testDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void findTest() throws Exception {
        TestDto testDto = TestDto.builder()
                .id(MOCK_ID).name(MOCK_NAME)
                .complexity(MOCK_COMPLEXITY).status(MOCK_STATUS)
                .build();
        when(testService.findByName(MOCK_NAME)).thenReturn(testDto);

        mockMvc.perform(get("/account/test/{name}", MOCK_NAME))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(testDto.getName()));
    }

    @Test
    void findAllTest() throws Exception {
        List<TestDto> testDtoList = List.of(TestDto.builder()
                .id(MOCK_ID).name(MOCK_NAME)
                .complexity(MOCK_COMPLEXITY).status(MOCK_STATUS)
                .build());
        when(testService.findAll()).thenReturn(testDtoList);

        mockMvc.perform(get("/account/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name")
                        .value(testDtoList.get(0).getName()));
    }

    @Test
    void deleteTest() throws Exception {
        doNothing().when(testService).removeByName(MOCK_NAME);

        mockMvc.perform(delete("/account/test/{name}", MOCK_NAME))
                .andExpect(status().isNoContent())
                .andDo(print());

        mockMvc.perform(delete("/account/test/{name}", MOCK_NAME))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(testService, times(2)).removeByName(MOCK_NAME);
    }
}