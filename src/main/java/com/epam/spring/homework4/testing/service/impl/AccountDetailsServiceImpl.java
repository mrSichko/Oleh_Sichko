package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;
import com.epam.spring.homework4.testing.model.AccountDetails;
import com.epam.spring.homework4.testing.repository.AccountDetailsRepository;
import com.epam.spring.homework4.testing.service.AccountDetailsService;
import com.epam.spring.homework4.testing.service.mapper.AccountDetailsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountDetailsServiceImpl implements AccountDetailsService {
    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    public AccountDetailsDto save(AccountDetailsDto accountDetailsDto) {
        log.info("save account_details for account with id - " + accountDetailsDto.getAccountId());
        AccountDetails accountDetails = AccountDetailsMapper.INSTANCE.mapAccountDetails(accountDetailsDto);
        accountDetailsRepository.save(accountDetails);
        return AccountDetailsMapper.INSTANCE.mapAccountDetailsDto(accountDetails);
    }

    @Override
    public AccountDetailsDto findByAccountId(Integer accountId) {
        log.info("find account_details for account with id - " + accountId);
        AccountDetails accountDetails = accountDetailsRepository.findByAccountId(accountId);
        return AccountDetailsMapper.INSTANCE.mapAccountDetailsDto(accountDetails);
    }

    @Override
    public void removeByAccountId(Integer accountId) {
        log.info("remove account_details for account with id - " + accountId);
        accountDetailsRepository.removeByAccountId(accountId);
    }
}
