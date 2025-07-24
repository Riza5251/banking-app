package net.javaguides.banking_app.mapper;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.entity.Account;

public class Mapper {

        public static Account maptoaccount(AccountDto accountDto)
        {
            return new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
        }

        public static AccountDto maptoaccountdto(Account account)
        {
            return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
        }
}
