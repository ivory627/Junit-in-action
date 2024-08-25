package com.study.junit.ch08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TestAccountService {

    @Test
    public void testTransferOk() {
        //given
        Account senderAccount = new Account("1", 200L);
        Account beneficiaryAccount = new Account("2", 100L);

        MockAccountManager mockAccountManager = new MockAccountManager();
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        //when
        accountService.transfer("1","2", 50L);

        //then
        assertEquals(150L, senderAccount.getBalance());
        assertEquals(150L, beneficiaryAccount.getBalance());
    }
}