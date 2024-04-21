package com.BankingApp.BankingApp.controller;

import com.BankingApp.BankingApp.dto.AccountDto;
import com.BankingApp.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    //http://localhost:8080/api/accounts/4
    @GetMapping("/{id}") // To Get Account Details Rest API
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
    return ResponseEntity.ok(accountDto);
    }

    //http://localhost:8080/api/accounts/3/deposit
   // {
    //    "amount":2000
   // }
    @PutMapping("/{id}/deposit")  // Deposit Amount in account Rest API
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
       Double amount = request.get("amount");
       AccountDto accountDto = accountService.deposit(id, amount);
    return ResponseEntity.ok(accountDto);
    }


    //http://localhost:8080/api/accounts/4/withdraw
    /*
    {
    "amount":400.0
    }
    */
    @PutMapping("/{id}/withdraw") // Withdraw amount in account Rest API
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
       Double amount = request.get("amount");
       AccountDto accountDto = accountService.withdraw(id , amount);
    return ResponseEntity.ok(accountDto);
    }


    // http://localhost:8080/api/accounts
    @GetMapping // To Get All Accounts details Rest API
    public ResponseEntity<List <AccountDto>> getAllAccount(){
      List<AccountDto> accountDto = accountService.getAllAccounts();
    return ResponseEntity.ok(accountDto);
    }

    // http://localhost:8080/api/accounts/4
    @DeleteMapping("/{id}") // Delete Account Rest API
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
          accountService.deleteAccount(id);
    return ResponseEntity.ok("Account deleted Successfully ...!!");
    }
}
