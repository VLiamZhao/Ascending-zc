package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.repository.DepartmentDao;
import com.ascending.training.repository.DepartmentDaoImpl;
import com.ascending.training.repository.EmployeeDao;
import com.ascending.training.repository.EmployeeDaoImpl;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDaoImplTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    DepartmentDao departmentDao = new DepartmentDaoImpl();
    Employee e1 = new Employee();
    Employee e2 = new Employee();
    Department d1 = new Department();


}
