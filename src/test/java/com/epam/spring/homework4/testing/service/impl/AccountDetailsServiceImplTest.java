package com.epam.spring.homework4.testing.service.impl;

import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;
import com.epam.spring.homework4.testing.model.AccountDetails;
import com.epam.spring.homework4.testing.repository.AccountDetailsRepository;
import com.epam.spring.homework4.testing.service.mapper.AccountDetailsMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountDetailsServiceImplTest {
    @InjectMocks
    private AccountDetailsServiceImpl accountDetailsService;

    @Mock
    private AccountDetailsRepository accountDetailsRepository;

    @Spy
    AccountDetailsMapper accountDetailsMapper = Mappers.getMapper(AccountDetailsMapper.class);

    private static final int MOCK_ID = 1;

    @Test
    void saveTest() {
        //Given
        AccountDetails accountDetails = AccountDetails.builder().firstName("Jon").lastName("Smith").build();
        when(accountDetailsRepository.save(accountDetails)).thenReturn(accountDetails);

        //When
        AccountDetailsDto accountDetailsDto = accountDetailsService.save(accountDetailsMapper
                .mapAccountDetailsDto(accountDetails));

        //Then
        assertEquals(accountDetails.getFirstName(), accountDetailsDto.getFirstName());
    }

    @Test
    void findByAccountIdTest() {
        //Given
        AccountDetails accountDetails = AccountDetails.builder().id(MOCK_ID).build();
        when(accountDetailsRepository.findByAccountId(MOCK_ID)).thenReturn(accountDetails);

        //When
        AccountDetailsDto accountDetailsDto = accountDetailsService.findByAccountId(MOCK_ID);

        //Then
        assertEquals(accountDetails.getId(), accountDetailsDto.getId());
    }

    @Test
    void removeByAccountIdTest() {
        //Given
        AccountDetails accountDetails = AccountDetails.builder().id(MOCK_ID).build();
        doNothing().when(accountDetailsRepository).removeByAccountId(MOCK_ID);

        //When
        accountDetailsService.removeByAccountId(MOCK_ID);
        accountDetailsService.removeByAccountId(MOCK_ID);

        //Then
        verify(accountDetailsRepository, times(2)).removeByAccountId(MOCK_ID);
    }
}