package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.repository.DepartmentDao;
import com.ascending.training.repository.DepartmentDaoImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentDaoImplTest {
    @Autowired
    private DepartmentDao departmentDao;
    Logger logger = LoggerFactory.getLogger(this.getClass());
//    DepartmentDao departmentDao = new DepartmentDaoImpl();
    Department depa;

    @Before
    public void init() {
        logger.debug("Test will start...");
        depa = new Department("office", "paperwork", "falls church");
        long deptId = 0L;
        Department temp =  departmentDao.save(depa);
        deptId = temp.getId();
        assert(deptId > 0);
    }

    @After
    public void tearDown() {
        logger.debug("Test will be finished soon...");
        boolean flag = false;
        flag = departmentDao.delete(depa.getName());
        assert(flag);
    }

    @Test
    public void getDepartments() {
        logger.debug("Departments will be gotten as a list...");
        List<Department> departments = departmentDao.getDepartments();
        int expectedSize = 8;
        Assert.assertEquals(expectedSize, departments.size());
    }
}
