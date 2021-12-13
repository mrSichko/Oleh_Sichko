package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.config.TestWebConfig;
import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.AccountService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = AccountController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@Import(TestWebConfig.class)
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private final ObjectMapper mapper = new ObjectMapper();

    private static final String MOCK_LOGIN = "login";
    private static final String MOCK_PASSWORD = "password";
    private static final String MOCK_EMAIL = "email@i.ua";


    @Test
    void createAccountTest() throws Exception {
        AccountDto accountDto = AccountDto.builder()
                .login(MOCK_LOGIN).password(MOCK_PASSWORD)
                .email(MOCK_EMAIL).build();
        when(accountService.createAccount(accountDto)).thenReturn(accountDto);

        mockMvc.perform(post("/account")
                        .content(mapper.writeValueAsString(accountDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }


    @Test
    void findTest() throws Exception {
        AccountDto accountDto = AccountDto.builder()
                .login(MOCK_LOGIN).password(MOCK_PASSWORD)
                .email(MOCK_EMAIL).build();
        when(accountService.findByLogin(MOCK_LOGIN)).thenReturn(accountDto);

        mockMvc.perform(get("/account/{login}", MOCK_LOGIN))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.login").value(accountDto.getLogin()));
    }

    @Test
    void findByEmailTest() throws Exception {
        AccountDto accountDto = AccountDto.builder()
                .login(MOCK_LOGIN).password(MOCK_PASSWORD)
                .email(MOCK_EMAIL).build();
        when(accountService.findByEmail(MOCK_EMAIL)).thenReturn(accountDto);

        mockMvc.perform(get("/account/email/{email}", MOCK_EMAIL))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(accountDto.getEmail()));
    }

    @Test
    void findAllTest() throws Exception {
        List<AccountDto> accountDtoList = List.of(AccountDto.builder()
                .login(MOCK_LOGIN).password(MOCK_PASSWORD)
                .email(MOCK_EMAIL).build());
        when(accountService.findAll()).thenReturn(accountDtoList);

        mockMvc.perform(get("/account"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].login")
                        .value(accountDtoList.get(0).getLogin()));
    }

    @Test
    void deleteAccountTest() throws Exception {
        doNothing().when(accountService).delete(MOCK_LOGIN);

        mockMvc.perform(delete("/account/{login}", MOCK_LOGIN))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(accountService, times(1)).delete(MOCK_LOGIN);
    }

    @Test
    void deleteAccountByEmailTest() throws Exception {
        doNothing().when(accountService).deleteByEmail(MOCK_EMAIL);

        mockMvc.perform(delete("/account/email/{email}", MOCK_EMAIL))
                .andExpect(status().isNoContent())
                .andDo(print());

        mockMvc.perform(delete("/account/email/{email}", MOCK_EMAIL))
                .andExpect(status().isNoContent())
                .andDo(print());

        verify(accountService, times(2)).deleteByEmail(MOCK_EMAIL);
    }
}