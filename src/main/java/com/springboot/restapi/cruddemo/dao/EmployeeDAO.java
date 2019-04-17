package com.springboot.restapi.cruddemo.dao;
import com.springboot.restapi.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
