package com.ascending.repository;

import com.ascending.model.Account;

import java.util.List;

public interface AccountDao {
    Account save(Account account);
//    Account update(Account account);
    boolean deleteById(long id);
    List<Account> getAccounts();
    Account getAccountById(long id);
}
