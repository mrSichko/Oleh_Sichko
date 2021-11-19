package com.epam.spring.homework4.testing.service.mapper;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    List<AccountDto> mapAccountsDto(List<Account> accountsList);

    AccountDto mapAccountDto(Account account);

    Account mapAccount(AccountDto accountDto);
}
