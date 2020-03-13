package com.ascending.com.repository;

import com.ascending.training.model.Account;
import com.ascending.training.repository.AccountDao;
import com.ascending.training.repository.AccountDaoImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class AccountDaoImplTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private AccountDao accountDao = new AccountDaoImpl();
    private Account accTest;
    BigDecimal balanceNum = new BigDecimal("13.2");
    Account account = new Account("test", balanceNum, 2);

    @Before
    public void setUp() {
        logger.debug("Test will begin soon...");
        accTest = accountDao.save(account);
        long accId = 0;
        accId = accTest.getId();
        assert(accId != 0);
    }

    @After
    public void tearDwon() {
        logger.debug("Test will be finished...");
        assert(accountDao.deleteById(accTest.getId()));
    }

    @Test
    public void getAccounts(){
        List<Account> accountList = accountDao.getAccounts();
        int expectedNumOfAccounts = 7;
        Assert.assertEquals(expectedNumOfAccounts, accountList.size());
    }

}
