package com.ascending.service;

import com.ascending.model.Employee;
import com.ascending.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    public boolean deleteById(long id) {
        return employeeDao.deleteById(id);
    }

    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    public Employee getEmployeeById(long id) {
        return employeeDao.getEmployeeById(id);
    }

    public Employee getEmployeeByName(String name) { return employeeDao.getEmployeeByName(name); }
}
//    Employee save(Employee employee);
//
////    int updateEmployeeAddressByName(String name, String address);
//      boolean deleteById(long id);
//      List<Employee> getEmployees();
////    List<Employee> getEmployeesWithAccounts();
////    Employee getEmployeeByName(String name);
////    Employee getEmployeeWithAccountsByName(String name);
//      Employee getEmployeeById(long id);