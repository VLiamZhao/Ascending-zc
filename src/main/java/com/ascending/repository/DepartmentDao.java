package com.ascending.repository;

import com.ascending.model.Department;

import java.util.List;

public interface DepartmentDao {
    Department save(Department department);
    Department update(Department department);
    boolean delete(String deptName);
    List<Department> getDepartments();
    Department getDepartmentAndEmployees(String deptName);
//    List<Department> getDepartmentsWithChildren()
    Department getDepartmentByName(String deptName);
    Department getDepartmentById(long id);
}
