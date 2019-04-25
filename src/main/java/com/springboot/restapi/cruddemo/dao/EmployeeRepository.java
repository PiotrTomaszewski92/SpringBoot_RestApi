package com.springboot.restapi.cruddemo.dao;
import com.springboot.restapi.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { }
