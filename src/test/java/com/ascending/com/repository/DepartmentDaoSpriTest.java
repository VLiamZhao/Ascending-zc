package com.ascending.com.repository;

import com.ascending.training.init.ApplicationBootstrap;
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
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class DepartmentDaoSpriTest {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    Employee e1;
    Employee e2;
    Department d1;
    @Before
    public void init() {

        LocalDate l = LocalDate.now();
        e1 = new Employee("Hang San2");

        e2 = new Employee("Liu Si2");

        d1 = new Department("ITDP2");
        d1.setDescription("Eat and drink");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        e2.setDepartment(d1);
        e1.setDepartment(d1);
        d1.setEmployees(employeeList);
        assert(departmentDao.save(d1) != null);
        assert(employeeDao.save(e1) != null);
        assert(employeeDao.save(e2) != null);

    }

    @After
    public void tearDown() {
        assert(employeeDao.deleteById(e1.getId()));
        assert(employeeDao.deleteById(e2.getId()));
        assert(departmentDao.delete(d1.getName()));
    }

    @Test
    public void getDepartmentAndEmployeesTest() {
       Department testDept = departmentDao.getDepartmentAndEmployees("ITDP2");
        int expectedCount = 2;
        Assert.assertEquals(expectedCount, testDept.getEmployees().size());
    }

    @Test
    public void getDepartmentByName() {
        Department de = departmentDao.getDepartmentByName("ITDP2");
        String testString = "Eat and drink";
        Assert.assertEquals(testString, de.getDescription());
    }

    @Test
    public void getDepartments() {
        logger.debug("Departments will be gotten as a list...");
        List<Department> departments = departmentDao.getDepartments();
        int expectedSize = 7;
        Assert.assertEquals(expectedSize, departments.size());
    }

}
