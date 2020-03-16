package com.ascending.training.repository;

import com.ascending.training.model.Employee;
import com.ascending.training.util.HibernateUtil;
import com.github.fluent.hibernate.H;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Employee save(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        String hql = "DELETE Employee where id = :targetId";
        Transaction transaction = null;
        int deletedCount = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("targetId", id);
            deletedCount = query.executeUpdate();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error(e.getMessage());
        }
        logger.debug(String.format("The employee which id is %s was deleted", String.valueOf(id)));
        return deletedCount == 1;
    }

    @Override
    public List<Employee> getEmployees() {
        String hql = "FROM Employee";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            return (List<Employee>) query.list();
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(long id) {
        String hql = "FROM Employee as empl where empl.id =:targetId";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery(hql);
            query.setParameter("targetId", id);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
    @Override
    public Employee getEmployeeByName(String Ename) {
        String hql = "FROM Employee as empl where empl.name =:emName";
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery(hql);
            query.setParameter("emName", Ename);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

}
