package com.study.junit.ch08;

public class AccountService {

    private AccountManager accountManager;

    public void setAccountManager(AccountManager manager) {
        this.accountManager = manager;
    }

    public void transfer(String senderId, String beneficiaryId, Long amount) {
        Account sender = accountManager.findAccountForUser(senderId);
        Account beneficiary =  accountManager.findAccountForUser(beneficiaryId);

        sender.debit(amount);
        beneficiary.credit(amount);
        this.accountManager.updateAccount(sender);
        this.accountManager.updateAccount(beneficiary);
    }
}
