package com.BankingApp.BankingApp.mapper;

import com.BankingApp.BankingApp.dto.AccountDto;
import com.BankingApp.BankingApp.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){ // To map AccountDto data to Account or send data AccountDto to account

        Account account = new Account(

                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
    return account;
    }

    public static AccountDto mapToAccountDto(Account account){ //To map Account data to AccountDto or send data to Account to AccountDto

        AccountDto accountDto = new AccountDto(

                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    return accountDto;
    }
}
