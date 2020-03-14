package com.ascending.com.repository;

import com.ascending.training.model.Department;
import com.ascending.training.model.Employee;
import com.ascending.training.repository.DepartmentDao;
import com.ascending.training.repository.DepartmentDaoImpl;
import org.junit.Before;

import java.time.LocalDate;

public class DepartmentModelTest {
    @Before
    public void init() {
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        LocalDate l = LocalDate.now();
        Employee e1 = new Employee("Zhang San",
                "San",
                "Zhang",
                "zhangsan@gmail.com",
                "Falls Church",
                 l,
                2L
        );
        Employee e2 = new Employee("Li Si",
                "Si",
                "Li",
                "lisi@gmail.com",
                "Falls Church",
                l,
                2L);
        Department d1 = new Department("Archive", "Collect Files", "Falls Church");
    }
}
