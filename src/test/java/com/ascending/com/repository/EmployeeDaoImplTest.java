package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.repository.DepartmentDao;
import com.ascending.training.repository.DepartmentDaoImpl;
import com.ascending.training.repository.EmployeeDao;
import com.ascending.training.repository.EmployeeDaoImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeDaoImplTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    EmployeeDao employeeDao;
    DepartmentDao departmentDao;
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    Department d1 = new Department();

    @Before
    public void init() {
        departmentDao = new DepartmentDaoImpl();
        employeeDao = new EmployeeDaoImpl();
        d1 = new Department("debug team");
        e1 = new Employee("Andy");
        e2 = new Employee("Alice");
        d1 = departmentDao.save(d1);
        e1.setDepartment(d1);
        e2.setDepartment(d1);
        employeeDao.save(e1);
        employeeDao.save(e2);
    }

    @After
    public void tearDown() {
        employeeDao.deleteById(e1.getId());
        employeeDao.deleteById(e2.getId());
        departmentDao.delete(d1.getName());
    }


    @Test
    public void getEmployeesTest() {
        logger.debug("Employees will be gotten as a list...");
        List<Employee> employees = employeeDao.getEmployees();
        int expectedCount = 12;
        Assert.assertEquals(expectedCount, employees.size());
    }
}
