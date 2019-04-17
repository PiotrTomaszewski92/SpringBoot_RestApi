package com.springboot.restapi.cruddemo.rest;
import com.springboot.restapi.cruddemo.dao.EmployeeDAO;
import com.springboot.restapi.cruddemo.entity.Employee;
import com.springboot.restapi.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //quick and dirty: inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for GET /employes/{id}
    @GetMapping("/employees/{emplId}")
    public Employee getEmployee(@PathVariable int emplId){
        Employee employee = employeeService.findById(emplId);
        if(employee == null)
            throw new RuntimeException("Employee id not found: "+emplId);
        return employee;
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    //add mapping for DELETE /employees/id
    @DeleteMapping("/employees/{emplId}")
    public String deleteEmployee(@PathVariable int emplId){
        Employee employee = employeeService.findById(emplId);
        if(employee == null)
            throw new RuntimeException("Employee id not found: "+emplId);
        employeeService.deleteById(emplId);
        return "Deleted employee id - "+emplId;
    }
}


