package com.study.junit.ch08;

public class Account {
    private String accountId;
    private Long balance;

    public Account(String accountId, Long initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public void debit(Long amount) {
        this.balance -= amount;
    }

    public void credit(Long amount) {
        this.balance += amount;
    }

    public Long getBalance() {
        return this.balance;
    }
}
