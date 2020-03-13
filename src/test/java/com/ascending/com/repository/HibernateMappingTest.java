package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HibernateMappingTest {
  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void mappingDepartmentClassTest() {
    Department department = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      department = session.get(Department.class, 1L);
      logger.debug(department.getName());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    Assert.assertNotNull(department);
  }


}