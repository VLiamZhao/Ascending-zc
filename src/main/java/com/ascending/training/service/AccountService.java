package com.ascending.training.service;

import com.ascending.training.model.Account;
import com.ascending.training.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public Account save(Account account) {
        return accountDao.save(account);
    }

    public boolean deleteById(long id) {
        return accountDao.deleteById(id);
    }

    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

//    public Account getAccountById(long id) {
//        return accountDao.getAccountById(id);
//    }
}
//    Account save(Account account);
//    //    Account update(Account account);
//    boolean deleteById(long id);
//    List<Account> getAccounts();
////    Account getAccountById();