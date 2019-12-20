package com.github.joffryferrater.demo.demoapi.service;

import com.github.joffryferrater.demo.demoapi.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

class EmployeeServiceTest {

    private EmployeeService target;

    @BeforeEach
    void setUp() {
        target = new EmployeeService();
        target.initialEmployees();
    }

    @Test
    void shouldGetTheListOfEmployees() {
        List<Employee> result = target.getEmployees();

        assertThat(result, hasSize(1));
    }
}