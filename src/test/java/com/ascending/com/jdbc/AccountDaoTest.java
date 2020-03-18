package com.ascending.com.jdbc;

//
//public class AccountDaoTest {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    private AccountDao accountDao;
//    private Account testRecord;

//    @Before
//    public void setUp() {
//        logger.debug("Executing setUp before test...");
//        accountDao = new AccountDao();
//        long testAccountId = 0;
//        testRecord = new Account("test", new BigDecimal(439.91));
//        testRecord = accountDao.saveAccounts(testRecord);
//        testAccountId = testRecord.getId();
//        assert(testAccountId > 0);
//    }
//
//    @After
//    public void tearDown() {
//        logger.debug("Executing tearDown after test...");
//        boolean testResult = true;
//        testResult = accountDao.deleteAccount(testRecord.getId());
//        assert(testResult == false);
//    }
//
//    @Test
//    public void getAccountsTest() {
//        List<Account> accounts = accountDao.getAccounts();
//        int expectedNumOfAccounts = 6;
//        for (Account account : accounts) {
//            logger.debug(String.valueOf(accounts));
//        }
//        Assert.assertEquals(expectedNumOfAccounts, accounts.size());
//    }
//
//    @Test
//    public void getAccountByIdTest() {
//        Account temp = accountDao.getAccountById(testRecord.getId());
//        String expectedAccountType = "test";
//
////        Assert.assertEquals(temp.getId(), expectedAccountId);
//        Assert.assertEquals(expectedAccountType, temp.getAccount_type());
//    }
//}
