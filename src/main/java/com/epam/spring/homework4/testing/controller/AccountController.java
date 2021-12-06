package com.epam.spring.homework4.testing.controller;

import com.epam.spring.homework4.testing.controller.dto.AccountDto;
import com.epam.spring.homework4.testing.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/account")
    public AccountDto createAccount(@RequestBody @Valid AccountDto accountDto) {
        return accountService.createAccount(accountDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/{login}")
    public AccountDto find(@PathVariable String login) {
        return accountService.find(login);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account/email/{email}")
    public AccountDto findByEmail(@PathVariable String email) {
        return accountService.findByEmail(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/account")
    public List<AccountDto> findAll() {
        return accountService.findAll();
    }


    @DeleteMapping(value = "/account/{login}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String login) {
        accountService.delete(login);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/account/email/{email}")
    public ResponseEntity<Void> deleteAccountByEmail(@PathVariable String email) {
        accountService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
