package com.epam.spring.homework4.testing.repository;


import com.epam.spring.homework4.testing.exception.EntityNotFoundException;
import com.epam.spring.homework4.testing.model.Account;

import java.util.List;

public interface AccountRepository {

    Account createAccount(Account account);

    Account find(String login) throws EntityNotFoundException;

    List<Account> findAll();

    Account update(String login, Account account) throws EntityNotFoundException;

    void delete(String login);
}
