package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.AccountService;
import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("createAccount with login {}", accountDto.getLogin());
        Account account = mapAccountDtoToAccount(accountDto);
        account = accountRepository.createAccount(account);
        return mapAccountToAccountDto(account);
    }

    @Override
    public AccountDto find(String login) {
        log.info("find by login {}", login);
        Account account = accountRepository.find(login);
        return mapAccountToAccountDto(account);
    }

    @Override
    public List<AccountDto> findAll() {
        log.info("find all accounts");
        return accountRepository.findAll()
                .stream()
                .map(this::mapAccountToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto update(String login, AccountDto accountDto) {
        log.info("update account with login {}", login);
        Account account = mapAccountDtoToAccount(accountDto);
        account = accountRepository.update(login, account);
        return mapAccountToAccountDto(account);
    }

    @Override
    public void delete(String login) {
        log.info("delete account with login {}", login);
        accountRepository.delete(login);
    }

    private AccountDto mapAccountToAccountDto(Account account) {
        return AccountDto.builder()
                .login(account.getLogin())
                .email(account.getEmail())
                .languageId(account.getLanguageId())
                .roleId(account.getRoleId())
                .build();
    }

    private Account mapAccountDtoToAccount(AccountDto accountDto) {
        return Account.builder()
                .login(accountDto.getLogin())
                .email(accountDto.getEmail())
                .languageId(accountDto.getLanguageId())
                .roleId(accountDto.getRoleId())
                .build();
    }
}
