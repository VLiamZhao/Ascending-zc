package com.ascending.com.service;

import com.ascending.training.init.ApplicationBootstrap;
import com.ascending.training.model.Account;
import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.service.AccountService;
import com.ascending.training.service.DepartmentService;
import com.ascending.training.service.EmployeeService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class DepartmentServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    private Employee e1;
    private Department d1;
    private String accountType = "test3";
    private Account a1;
    private long accountId;

    @Before
    public void setUp(){
        logger.debug("SetUp before testing ...");
        a1 = new Account(accountType);
        d1 = new Department("reception");
        e1 = new Employee("Liam");
        departmentService.save(d1);
        e1.setDepartment(d1);
        employeeService.save(e1);
        a1.setEmployee(e1);
        accountId = 0;
        a1 = accountService.save(a1);
        assert (0 < a1.getId());
        accountId = a1.getId();
    }

    @After
    public void tearDown(){
        logger.debug("TearDown after testing ...");
        assert (accountService.deleteById(accountId));
        assert (employeeService.deleteById(e1.getId()));
        assert (departmentService.delete("reception"));
    }

    @Test
    public void getAccounts(){
        List<Account> accountList = accountService.getAccounts();

        int expectedNumOfAccounts = 7;
        Assert.assertEquals(expectedNumOfAccounts, accountList.size());
    }

    @Test
    public void getDpartments(){
        List<Department> dpartments = departmentService.getDepartments();

        int expectedNumOfAccounts = 8;
        Assert.assertEquals(expectedNumOfAccounts, dpartments.size());
    }
}