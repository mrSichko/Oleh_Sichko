package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.AccountService;
import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.repository.AccountRepository;
import com.epam.spring.homework4.testing.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("createAccount with login {}", accountDto.getLogin());
        Account account = AccountMapper.INSTANCE.mapAccount(accountDto);
        account.setCreateTime(Timestamp.from(Instant.now()));
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.mapAccountDto(account);
    }

    @Override
    public AccountDto find(String login) {
        log.info("find by login {}", login);
        Account account = accountRepository.findByLogin(login);
        return AccountMapper.INSTANCE.mapAccountDto(account);
    }

    @Override
    public List<AccountDto> findAll() {
        log.info("find all accounts");
        return AccountMapper.INSTANCE.mapAccountsDto(accountRepository.findAll());
    }

    @Override
    public void delete(String login) {
        log.info("delete account with login {}", login);
        accountRepository.removeByLogin(login);
    }

}
