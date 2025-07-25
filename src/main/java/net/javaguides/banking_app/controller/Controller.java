package net.javaguides.banking_app.controller;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id)
    {
        AccountDto accountDto=accountService.getAccount(id);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/get")
    public ResponseEntity<List<AccountDto>> getAllAccount()
    {
        List<AccountDto> accountDtos = accountService.getAllAccount();
        return ResponseEntity.ok(accountDtos);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String ,Double> request)
    {
        AccountDto accountDto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String ,Double> request)
    {
        AccountDto accountDto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return new ResponseEntity<String>("Account deleted", HttpStatus.OK);
    }
}
