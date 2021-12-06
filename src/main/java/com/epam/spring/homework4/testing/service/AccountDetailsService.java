package com.epam.spring.homework4.testing.service;

import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;

public interface AccountDetailsService {
    AccountDetailsDto save(AccountDetailsDto accountDetailsDto);

    AccountDetailsDto findByAccountId(Integer accountId);

    void removeByAccountId(Integer accountId);
}
