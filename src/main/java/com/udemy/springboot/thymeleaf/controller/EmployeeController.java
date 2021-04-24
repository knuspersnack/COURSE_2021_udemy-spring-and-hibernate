package com.udemy.springboot.thymeleaf.controller;

import com.udemy.springboot.thymeleaf.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList;

    @PostConstruct
    private  void loadData() {
        Employee emp1 = new Employee(1, "Leslie", "Andrews", "test@luv2Code.com");
        Employee emp2 = new Employee(2, "Hans", "Müller", "test@luv2Code.com");
        Employee emp3 = new Employee(3, "Hannah", "Stevens", "test@luv2Code.com");

        employeeList = new ArrayList<>();

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeList);
        return "list-employees";
    }

}
