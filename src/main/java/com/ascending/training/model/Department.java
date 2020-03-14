package com.ascending.training.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    public Department() {}
    public Department(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String location(){
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<Employee> getEmployees() {
        /* This solve the session closed exception when the fetch type is lazy */
        try {
            int size = employees.size();
        }
        catch (Exception e) {
            return null;
        }

        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        /* Create link between parent and children objects automatically */
        for (Employee e : employees) {
            if (e.getDepartment() == null) e.setDepartment(this);
        }

        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employee.setDepartment(this);
        employees.add(employee);
    }

}
