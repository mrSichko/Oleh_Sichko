package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.repository.AccountRepository;
import com.epam.spring.homework4.testing.service.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Spy
    private AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);

    private static final String MOCK_LOGIN = "fakeLogin";

    private static final String MOCK_EMAIL = "fakeEmail@i.ua";

    @Test
    void createAccountTest() {
        //Given
        Account expectedAccount = Account.builder()
                .login(MOCK_LOGIN).email(MOCK_EMAIL).build();
        when(accountRepository.save(expectedAccount)).thenReturn(expectedAccount);

        //When
        AccountDto actualAccountDto = accountService.createAccount(accountMapper.mapAccountDto(expectedAccount));

        //Then
        assertEquals(expectedAccount.getLogin(), actualAccountDto.getLogin());

    }

    @Test
    void findByLoginTest() {
        //Given
        Account account = Account.builder().login(MOCK_LOGIN).build();
        when(accountRepository.findByLogin(MOCK_LOGIN)).thenReturn(account);

        //When
        AccountDto accountDto = accountService.findByLogin(MOCK_LOGIN);

        //Then
        assertEquals(account.getLogin(), accountDto.getLogin());
    }

    @Test
    void findByEmailTest() {
        //Given
        Account account = Account.builder().email(MOCK_EMAIL).build();
        when(accountRepository.findByEmail(MOCK_EMAIL)).thenReturn(account);

        //When
        AccountDto accountDto = accountService.findByEmail(MOCK_EMAIL);

        //Then
        assertEquals(account.getEmail(), accountDto.getEmail());
    }

    @Test
    void findAllTest() {
        //Given
        Account account = Account.builder().login(MOCK_LOGIN).build();
        when(accountRepository.findAll()).thenReturn(List.of(account));

        //When
        List<AccountDto> accountDtoList = accountService.findAll();

        //Then
        assertEquals(1, accountDtoList.size());
    }

    @Test
    void deleteByEmailTest() {
        //Given
        doNothing().when(accountRepository).removeByEmail(MOCK_EMAIL);

        //When
        accountService.deleteByEmail(MOCK_EMAIL);

        //Then
        verify(accountRepository, times(1)).removeByEmail(MOCK_EMAIL);
    }

    @Test
    void deleteTest() {
        //Given
        doNothing().when(accountRepository).removeByLogin(MOCK_LOGIN);

        //When
        accountService.delete(MOCK_LOGIN);
        accountService.delete(MOCK_LOGIN);

        //Then
        verify(accountRepository, times(2)).removeByLogin(MOCK_LOGIN);
    }
}