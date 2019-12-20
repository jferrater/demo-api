package com.github.joffryferrater.demo.demoapi.service;

import com.github.joffryferrater.demo.demoapi.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    @PostConstruct
    void initialEmployees() {
        Employee employee = new Employee();
        employee.setUsername("joffry");
        employee.setName("Joffry Ferrater");
        employee.setManager("Jolly Jae Ompod");
        employee.setPhoneNumber("1234567");
        employee.setSalary("100000");
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
