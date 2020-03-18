package com.ascending.repository;

import com.ascending.model.Department;
import com.ascending.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
//        String hql = "FROM Department d where id = :deptId";
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createQuery(hql);
//            query.setParameter("deptId", department.getId());
//        }
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

    @Override
    public Department getDepartmentAndEmployees(String deptName) {
        if (deptName == null) return null;
        String hql = "FROM Department as dept left join fetch dept.employees where lower(dept.name) = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("name", deptName.toLowerCase());
            return query.uniqueResult();
//            for (Object[] obj : resultList) {
//                logger.debug(((Department)obj[0]).toString());
//                logger.debug(((Employee)obj[1]).toString());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Department getDepartmentByName(String deptName) {
        String hql = "FROM Department as dept WHERE lower(dept.name) = :deptName";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("deptName", deptName.toLowerCase());
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Department getDepartmentById(long Did) {
        String hql = "FROM Department as dept WHERE as.id = :deptId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("deptId", Did);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

//    @Override
//    public List<Department> getDepartmentsWithChildren() {
//        String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
//        try (Session session = HibernateUtil.getSessionFactory().openSession()){
//            Query<Department> query = session.createQuery(hql);
//            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
////            session.close();
//        }
//        catch (Exception e){
//            logger.error(e.getMessage());
//        }
//        return null;
//    }

//    public static void main(String[] args) {
//        DepartmentDao  departmentDao = new DepartmentDaoImpl();
//        List<Department> depts = departmentDao.getDepartments();
//        System.out.println(depts.size());
//    }
}
