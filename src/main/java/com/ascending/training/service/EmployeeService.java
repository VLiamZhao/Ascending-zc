package com.ascending.training.service;

import com.ascending.training.model.Employee;
import com.ascending.training.repository.EmployeeDao;
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