package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.model.Account;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto find(String login);

    List<AccountDto> findAll();

    AccountDto update(String login, AccountDto accountDto);

    void delete(String login);
}
