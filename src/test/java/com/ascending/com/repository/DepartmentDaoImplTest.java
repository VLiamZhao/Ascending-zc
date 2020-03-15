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

import java.util.List;

public class DepartmentDaoImplTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    Department department = new Department("office", "paperwork", "falls church");

    @Before
    public void init() {
        logger.debug("Test will start...");
        long deptId = 0L;
        Department temp =  departmentDao.save(department);
        deptId = temp.getId();
        assert(deptId > 0);
    }

    @After
    public void tearDown() {
        logger.debug("Test will be finished soon...");
        boolean flag = false;
        flag = departmentDao.delete(department.getName());
        assert(flag);
    }

    @Test
    public void getDepartments() {
        logger.debug("Departments will be gotten as a list...");
        List<Department> departments = departmentDao.getDepartments();
        int expectedSize = 7;
        Assert.assertEquals(expectedSize, departments.size());
    }
}
