package com.epam.spring.homework4.testing.repository;


import com.epam.spring.homework4.testing.model.Account;

import java.util.List;

public interface AccountRepository {

    Account createAccount(Account account);

    Account find(String login);

    List<Account> findAll();

    Account update(String login, Account account);

    void delete(String login);
}
