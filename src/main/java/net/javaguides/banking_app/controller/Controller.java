package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class Controller {

    private AccountService accountService;

    public Controller(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
           AccountDto accountDto1= accountService.createAccount(accountDto);
           return ResponseEntity.ok(accountDto1);
    }
}
