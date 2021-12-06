package com.epam.spring.homework4.testing.service.mapper;

import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;
import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.model.Account;
import com.epam.spring.homework4.testing.model.AccountDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountDetailsMapper {
    AccountDetailsMapper INSTANCE = Mappers.getMapper(AccountDetailsMapper.class);

    AccountDetailsDto mapAccountDetailsDto(AccountDetails accountDetails);

    AccountDetails mapAccountDetails(AccountDetailsDto accountDetailsDto);

}
