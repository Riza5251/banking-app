package net.javaguides.banking_app.service;

import net.javaguides.banking_app.dto.AccountDto;
import org.springframework.stereotype.Service;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
}
