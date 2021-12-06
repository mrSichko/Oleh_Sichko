package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.exception.EntityNotFoundException;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto find(String login) throws EntityNotFoundException;

    AccountDto findByEmail(String email);

    List<AccountDto> findAll();

    void deleteByEmail(String email);

    void delete(String login);
}
