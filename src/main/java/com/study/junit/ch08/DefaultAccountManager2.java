package com.study.junit.ch08;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultAccountManager2 implements AccountManager {
    private Log logger;
    private Configuration configuration;

    public DefaultAccountManager2() {
        this(LogFactory.getLog(DefaultAccountManager2.class),
                new DefaultConfiguration("technical"));
    }

    public DefaultAccountManager2(Log logger, Configuration configuration) {
        this.logger = logger;
        this.configuration = configuration;
    }

    @Override
    public Account findAccountForUser(String userId) {
        logger.debug("Getting account for user [" + userId + "]");
        this.configuration.getSQL("FIND_ACCOUNT_FOR_USER");
        // ... JDBC를 사용하여 유저의 계좌정보를 가져오는 비즈니스 로직 //
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
