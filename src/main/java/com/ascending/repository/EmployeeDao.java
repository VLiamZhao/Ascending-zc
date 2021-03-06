package com.ascending.repository;

import com.ascending.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee save(Employee employee);

//    int updateEmployeeAddressByName(String name, String address);
    boolean deleteById(long id);
    List<Employee> getEmployees();
//    List<Employee> getEmployeesWithAccounts();
    Employee getEmployeeByName(String name);
//    Employee getEmployeeWithAccountsByName(String name);
    Employee getEmployeeById(long id);
}
