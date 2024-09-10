package com.study.junit.ch08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TestAccountServiceEasyMock {

    // 모의하려는 객체를 인스턴스 변수로 선언. EasyMock 프레임워크는 인터페이스만 모의 가능
    private AccountManager mockAccountManager;

    @BeforeEach
    public void setUp() {
        // createMock을 통해 원하는 클래스의 모의 객체 생성
        mockAccountManager = createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        //given
        Account senderAccount = new Account("1", 200L);
        Account beneficiaryAccount = new Account("2", 100L);

        // 기대를 정의한다.
        mockAccountManager.updateAccount(senderAccount);
        mockAccountManager.updateAccount(beneficiaryAccount);

        expect(mockAccountManager.findAccountForUser("1"))
                .andReturn(senderAccount);

        expect(mockAccountManager.findAccountForUser("2"))
                .andReturn(beneficiaryAccount);

        // 기대 정의가 끝나면 replay를 호출한다.
        replay(mockAccountManager);

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        //when
        accountService.transfer("1","2", 50L);

        //then
        assertEquals(150L, senderAccount.getBalance());
        assertEquals(150L, beneficiaryAccount.getBalance());
    }

    @AfterEach
    public void tearDown() {
        verify(mockAccountManager);
    }
}