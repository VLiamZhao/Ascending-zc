package com.ascending.training.controller;


import com.ascending.training.model.Account;
import com.ascending.training.model.Employee;
import com.ascending.training.service.AccountService;
import com.ascending.training.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/accounts")
public class AccountController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    AccountService accountService;
    @Autowired
    EmployeeService employeeService;
    /**
     * POST /accounts?enName=value
     * @param account
     * @param employeeName
     * @return
     */
    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Account createAccount(@RequestParam(name = "emName") String employeeName, @RequestBody Account account){
        account.setEmployee(employeeService.getEmployeeByName(employeeName));
        Account account1 = accountService.save(account);
        return account1;
    }

    /**
     * GET /accounts
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Account> getAccounts(){
        List<Account> accountList = accountService.getAccounts();
        return accountList;
    }

    /**
     * GET /accounts/{id}
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Account getAccountById(@PathVariable long id){
        Account account = accountService.getAccountById(id);
        return account;
    }

    /**
     * DELETE /accounts/{id}
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteAccountById(@PathVariable long id){
        return accountService.deleteById(id);
    }
}
