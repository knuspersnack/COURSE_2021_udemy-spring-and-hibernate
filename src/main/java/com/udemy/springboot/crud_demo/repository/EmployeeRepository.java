package com.udemy.springboot.crud_demo.repository;


import com.udemy.springboot.crud_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
