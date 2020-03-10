package com.ascending.com.jdbc;

import com.ascending.training.jdbc.DepartmentDao;
import com.ascending.training.model.Department;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class DepartmentDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DepartmentDao departmentDao;

    @Before
    public void init() {
        departmentDao = new DepartmentDao();
    }

    @Test
    public void getDepartmentsTest() {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;

        for (Department department : departments) {
            logger.debug(String.valueOf(department));
        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }
}
