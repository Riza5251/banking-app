package net.javaguides.banking_app.service;

import net.javaguides.banking_app.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(Long id);
    List<AccountDto> getAllAccount();
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id,double amount);
    void deleteAccount(Long id);
}
