package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.config.TestWebConfig;
import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;
import com.epam.spring.homework4.testing.service.AccountDetailsService;
import com.epam.spring.homework4.testing.service.impl.AccountDetailsServiceImpl;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = AccountDetailsController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Import(TestWebConfig.class)
class AccountDetailsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountDetailsService accountDetailsService;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final int MOCK_ID = 1;
    private static final int MOCK__ACCOUNT_ID = 99;

    @Test
    void createAccountDetailsTest() throws Exception {
        AccountDetailsDto accountDetailsDto = AccountDetailsDto.builder()
                .id(MOCK_ID).accountId(MOCK__ACCOUNT_ID).build();
        when(accountDetailsService.save(accountDetailsDto)).thenReturn(accountDetailsDto);

        mockMvc.perform(post("/account/account-details/")
                        .content(mapper.writeValueAsString(accountDetailsDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    void findTest() throws Exception {
        AccountDetailsDto accountDetailsDto = AccountDetailsDto.builder()
                .id(MOCK_ID).accountId(MOCK__ACCOUNT_ID).build();

        when(accountDetailsService.findByAccountId(MOCK__ACCOUNT_ID)).thenReturn(accountDetailsDto);

        mockMvc.perform(get("/account/account-details/{accountId}", MOCK__ACCOUNT_ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.accountId").value(accountDetailsDto.getAccountId()));
    }

    @Test
    void deleteAccountDetailsTest() throws Exception {
        doNothing().when(accountDetailsService).removeByAccountId(MOCK__ACCOUNT_ID);

        mockMvc.perform(delete("/account/account-details/{accountId}", MOCK__ACCOUNT_ID))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(accountDetailsService, times(1)).removeByAccountId(MOCK__ACCOUNT_ID);
    }
}