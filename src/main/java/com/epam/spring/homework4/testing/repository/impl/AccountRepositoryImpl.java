package com.epam.spring.homework4.testing.repository.impl;

import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountRepositoryImpl implements AccountRepository {
    private final List<Account> list = new ArrayList<>();

    @Override
    public Account createAccount(Account account) {
        account.setCreateTime(Timestamp.from(Instant.now()));
        list.add(account);
        return account;
    }

    @Override
    public Account find(String login) {
        return list.stream()
                .filter(account -> account.getLogin().equals(login)).findFirst()
                .orElseThrow(() -> new RuntimeException("Account is not found!"));
    }

    @Override
    public List<Account> findAll() {
        return list;
    }

    @Override
    public Account update(String login, Account account) {
        boolean isDeleted = list.removeIf(u -> u.getLogin().equals(login));
        if (isDeleted) {
            list.add(account);
        } else {
            throw new RuntimeException("Account is not found!");
        }
        return account;

    }

    @Override
    public void delete(String login) {
        list.removeIf(account -> account.getLogin().equals(login));
    }
}
