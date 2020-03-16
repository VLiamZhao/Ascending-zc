package com.ascending.training.controller;

import com.ascending.training.model.Employee;
import com.ascending.training.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired EmployeeService employeeService;

  /**
   * POST /employees?deptName=value
   *
   * @param employee
   * @param deptName
   * @return
   */
  @RequestMapping(
      value = "",
      method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public Employee createEmployee(
      @RequestBody Employee employee, @RequestParam(name = "deptName") String deptName) {
    Employee em = null;
    try {
      em.setName(deptName);
      em = employeeService.save(employee);
    } catch (Exception e) {
      logger.debug(String.format("The department record name of %s failed to inserted."), deptName);
      logger.debug(e.getMessage());
    }
    return em;
  }

  /**
   * GET /employees
   *
   * @return
   */
  @RequestMapping(
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<Employee> getEmployees() {
    List<Employee> employeeList = employeeService.getEmployees();
    return employeeList;
  }

  /**
   * GET /employees/id
   *
   * @param id
   * @return
   */
  @RequestMapping(
      value = "/{id}",
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public Employee getEmployeeById(@PathVariable long id) {
    Employee em = employeeService.getEmployeeById(id);
    return em;
  }

  /**
   * GET /employees/employeeName?name=value
   *
   * @param name
   * @return
   */
  @RequestMapping(
      value = "/emloyeeName",
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public Employee getEmployeeByName(@RequestParam(name = "name") String name) {
    Employee em = employeeService.getEmployeeByName(name);
    return em;
  }
}