package com.BankingApp.BankingApp.serviceImp;

import com.BankingApp.BankingApp.Repository.AccountRepository;
import com.BankingApp.BankingApp.dto.AccountDto;
import com.BankingApp.BankingApp.entity.Account;
import com.BankingApp.BankingApp.mapper.AccountMapper;
import com.BankingApp.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    @Override //To add account Service Logic
    public AccountDto CreateAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override // To Get Account Details Service Logic
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not Exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override // Service logic for Add or deposit Amount in account
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double totalBalance = account.getBalance() + amount;
        account.setBalance(totalBalance);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override  // Service Logic for withdraw amount in account
    public AccountDto withdraw(Long id, double amount) {

       Account account  = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exist"));
          //less then balance Condition
       if(account.getBalance()<amount){
           throw new RuntimeException("Insufficient Balance");
       }
       double totalBalance = account.getBalance() - amount;
       account.setBalance(totalBalance);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override // To Get all account details Service logic
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override // To Delete account Service logic
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
        accountRepository.delete(account);
    }
}
