package com.study.junit.ch08;

public class TestDefaultAccountManager {

    public void testFindAccountByUser() {
        MockLog logger = new MockLog();
        MockConfiguration configuration = new MockConfiguration();
        configuration.setSQL("SELECT * FROM [...]");
        DefaultAccountManager2 am = new DefaultAccountManager2(logger, configuration);

        Account account = am.findAccountForUser("1234");

        //...
    }
}
