package com.study.junit.ch08;

public interface AccountManager {

    Account findAccountForUser(String userId);

    void updateAccount(Account account);
}
