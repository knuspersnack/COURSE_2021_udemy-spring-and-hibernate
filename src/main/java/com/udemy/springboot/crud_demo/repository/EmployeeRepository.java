package com.udemy.springboot.crud_demo.repository;


import com.udemy.springboot.crud_demo.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}
