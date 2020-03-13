package com.ascending.training.repository;

import com.ascending.training.model.Account;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;

public class AccountDaoImpl implements AccountDao{
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public List<Account> getAccounts() {
        String hql = "From Account";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            return (List<Account>) query.list();
        }
        catch (Exception e){
            logger.debug(e.getMessage());
            return null;
        }
    }

    @Override
    public Account save(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
            return account;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteById(long targetId) {
        String hql = "DELETE Account where id = :targetId";
        int deletedCount = 0;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("targetId", targetId);
            deletedCount = query.executeUpdate();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The account which id is %s was deleted", String.valueOf(targetId)));
        return deletedCount == 1;
    }
//    public static void main(String[] args) {
//        Account a = new Account("test2", new BigDecimal(90.1), 2);
//        Account b = null;
//        AccountDao acc = new AccountDaoImpl();
//        List<Account> accList = acc.getAccounts();
////        b = acc.save(a);
//        System.out.println(accList);
//    }
}
