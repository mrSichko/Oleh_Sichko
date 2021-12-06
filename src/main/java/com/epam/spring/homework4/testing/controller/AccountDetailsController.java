package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.controller.dto.AccountDetailsDto;
import com.epam.spring.homework4.testing.service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountDetailsController {
    private final AccountDetailsService accountDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/account/account-details")
    public AccountDetailsDto createAccountDetails(@RequestBody @Valid AccountDetailsDto accountDetailsDto) {
        return accountDetailsService.save(accountDetailsDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/account-details/{accountId}")
    public AccountDetailsDto find(@PathVariable Integer accountId) {
        return accountDetailsService.findByAccountId(accountId);
    }

    @DeleteMapping(value = "/account/account-details/{accountId}")
    public ResponseEntity<Void> deleteAccountDetails(@PathVariable Integer accountId) {
        accountDetailsService.removeByAccountId(accountId);
        return ResponseEntity.noContent().build();
    }
}
