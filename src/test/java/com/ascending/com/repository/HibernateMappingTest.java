package com.ascending.com.repository;

import com.ascending.model.Department;
import com.ascending.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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