package com.BankingApp.BankingApp.controller;

import com.BankingApp.BankingApp.dto.AccountDto;
import com.BankingApp.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired (required=true)
    private AccountService accountService;

    //{
    //    "accountHolderName":"Sunil Sharma",
     //       "balance":50000
   // }
    // http://localhost:8080/api/accounts
    //http://3.108.254.132:9090/api/accounts
    @PostMapping //
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        System.out.println("accountDto :-" + accountDto);
        return new ResponseEntity<>(accountService.CreateAccount(accountDto), HttpStatus.CREATED);
    }
}
