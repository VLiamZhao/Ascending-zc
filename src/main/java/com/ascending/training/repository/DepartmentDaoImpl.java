package com.ascending.training.repository;

import com.ascending.training.model.Department;
import com.ascending.training.util.HibernateUtil;
import com.github.fluent.hibernate.H;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Synchronization;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao{
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Department save(Department department) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return department;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public boolean delete(String deptName) {
        String hql = "Delete Department d where d.name = :deptname1";
        int deletedCount = 0;
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("deptname1", deptName);
            deletedCount = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The department %s was deleted", deptName));
        return deletedCount >= 1;
    }

    @Override
    public List<Department> getDepartments() {
        String hql = "From Department";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            return (List<Department>) query.list();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return null;
        }
    }
}
