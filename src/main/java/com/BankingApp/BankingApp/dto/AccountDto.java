package com.BankingApp.BankingApp.dto;

public class AccountDto {
    private long id;

    private String AccountHolderName;

    private double balance;


    public AccountDto() {
        super();
    }

    public AccountDto(long id, String accountHolderName, double balance) {
        super();
        this.id = id;
        AccountHolderName = accountHolderName;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        AccountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
