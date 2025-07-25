package net.javaguides.banking_app.service.impl;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.mapper.Mapper;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

        private Mapper mapper;
    private AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account create =mapper.maptoaccount(accountDto);
        Account saved=accountRepository.save(create);
        return mapper.maptoaccountdto(saved);
    }

    @Override
    public AccountDto getAccount(Long id) {
      Account  account= accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist "));
      return mapper.maptoaccountdto(account);

    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> list=accountRepository.findAll();
         return list.stream().map((account)->mapper.maptoaccountdto(account)).collect(Collectors.toList());

    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedaccount=accountRepository.save(account);
        return mapper.maptoaccountdto(account);

    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account does not exist"));
        if(account.getBalance()<amount)
            throw new RuntimeException("Insufficient Balance");
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedaccount=accountRepository.save(account);
        return mapper.maptoaccountdto(account);

    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
