package com.epam.spring.homework4.testing.service.repository;


import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.model.Account;

import java.util.List;

public interface AccountRepository {

    Account createAccount(Account account);

    Account find(String login);

    List<Account> findAll();

    Account update(String login, Account account);

    void delete(String login);
}
