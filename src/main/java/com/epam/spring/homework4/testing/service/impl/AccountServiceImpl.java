package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.AccountService;
import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.repository.AccountRepository;
import com.epam.spring.homework4.testing.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        account = accountRepository.createAccount(account);
        return AccountMapper.INSTANCE.mapAccountDto(account);
    }

    @Override
    public AccountDto find(String login) {
        log.info("find by login {}", login);
        Account account = accountRepository.find(login);
        return AccountMapper.INSTANCE.mapAccountDto(account);
    }

    @Override
    public List<AccountDto> findAll() {
        log.info("find all accounts");
        return AccountMapper.INSTANCE.mapAccountsDto(accountRepository.findAll());
    }

    @Override
    public AccountDto update(String login, AccountDto accountDto) {
        log.info("update account with login {}", login);
        Account account = AccountMapper.INSTANCE.mapAccount(accountDto);
        account = accountRepository.update(login, account);
        return AccountMapper.INSTANCE.mapAccountDto(account);
    }

    @Override
    public void delete(String login) {
        log.info("delete account with login {}", login);
        accountRepository.delete(login);
    }

}
