package com.ascending.com.jdbc;

import com.ascending.training.jdbc.AccountDao;
import com.ascending.training.model.Account;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AccountDao accountDao;
    private Account testRecord;

    @Before
    public void setUp() {
        logger.debug("Executing setUp before test...");
        accountDao = new AccountDao();
        long testAccountId = 0;
        testRecord = new Account("test", 439.91, 1);
        testRecord = accountDao.saveAccounts(testRecord);
        testAccountId = testRecord.getId();
        assert(testAccountId > 0);
    }

    @After
    public void tearDown() {
        logger.debug("Executing tearDown after test...");
        boolean testResult = true;
        testResult = accountDao.deleteAccount(testRecord.getId());
        assert(testResult == false);
    }

    @Test
    public void getAccountsTest() {
        List<Account> accounts = accountDao.getAccounts();
        int expectedNumOfAccounts = 5;
        for (Account account : accounts) {
            logger.debug(String.valueOf(accounts));
        }
        Assert.assertEquals(expectedNumOfAccounts, accounts.size());
    }
}
