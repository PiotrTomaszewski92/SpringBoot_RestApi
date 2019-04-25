package com.springboot.restapi.cruddemo.service;
import com.springboot.restapi.cruddemo.dao.EmployeeRepository;
import com.springboot.restapi.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceRepositoryImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceRepositoryImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent())
            employee = result.get();
        else
            throw new RuntimeException("Didn't find employee id: "+id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}

