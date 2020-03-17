package com.ascending.training.controller;

import com.ascending.training.model.Department;
import com.ascending.training.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/departments"})
public class DepartmentController {
  private Logger logger = LoggerFactory.getLogger(getClass());
  @Autowired private DepartmentService departmentService;

  /**
   * GET /departments
   *
   * @return
   */
  @RequestMapping(
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public List<Department> getDepartments() {
    List<Department> departments = departmentService.getDepartments();
    return departments;
  }

  /**
   * POST /departments/body
   *
   * @param department
   * @return
   */
  @RequestMapping(
      value = "/body",
      method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public Department createDepartment(@RequestBody Department department) {
    Department dept = departmentService.save(department);
    return dept;
  }

  /**
   * GET /departments/{id}
   *
   * @param id
   * @return
   */
  @RequestMapping(
      value = "/{id}",
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public Department getDepartmentById(@PathVariable long id) {
    Department dept = departmentService.getDepartmentById(id);
    return dept;
  }

  /**
   * GET /departments/?deptName=value
   *
   * @param name
   * @return
   */
  @RequestMapping(
      value = "/name",
      method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public Department getDepartmentByName(@RequestParam(name = "deptName") String name) {
    Department dept = departmentService.getDepartmentByName(name);
    return dept;
  }

  /**
   * PUT /departments
   *
   * @param department
   * @return
   */
  @RequestMapping(
      value = "",
      method = RequestMethod.PUT,
      consumes = {MediaType.APPLICATION_JSON_VALUE})
  public Department updateDepartment(@RequestBody Department department) {
    Department dept = departmentService.update(department);
    return dept;
  }
}
