package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.repository.DepartmentDao;
import com.ascending.training.repository.DepartmentDaoImpl;
import com.ascending.training.repository.EmployeeDao;
import com.ascending.training.repository.EmployeeDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepartmentModelTest {
    @Before
    public void init() {
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        LocalDate l = LocalDate.now();
        Employee e1 = new Employee("Zhang San",
                "San",
                "Zhang",
                "zhangsan@gmail.com",
                "Falls Church", l);
        Employee e2 = new Employee("Li Si",
                "Si",
                "Li",
                "lisi@gmail.com",
                "Falls Church", l);
        Department d1 = new Department("Archive", "Collect Files", "Falls Church");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        e2.setDepartment(d1);
        e1.setDepartment(d1);
        d1.setEmployees(employeeList);
        departmentDao.save(d1);
        employeeDao.save(e1);
        employeeDao.save(e2);

    }

    @Test
    public void tempTest() {

    }
}
