package com.BankingApp.BankingApp.service;

import com.BankingApp.BankingApp.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountDto CreateAccount(AccountDto accountDto); //create accounts

    AccountDto getAccountById(Long id); // help of id will get accounts

    AccountDto deposit(Long id, double amount); // help of id will get account and add amount

    AccountDto withdraw(Long id, double amount); //  help of id will get account and withdraw amount

    List<AccountDto> getAllAccounts(); // to get all accounts

    void deleteAccount(Long id); // delete account with help of id
}
