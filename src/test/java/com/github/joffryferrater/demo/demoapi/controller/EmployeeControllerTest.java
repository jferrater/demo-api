package com.github.joffryferrater.demo.demoapi.controller;

import com.github.joffryferrater.demo.demoapi.model.Employee;
import com.github.joffryferrater.demo.demoapi.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = mock(EmployeeService.class);
    }

    @Test
    void shouldReturnListOfEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setUsername("joffry");
        employee.setName("Joffry Ferrater");
        employee.setManager("Jolly Jae Ompod");
        List<Employee> employees = Arrays.asList(employee);
        when(employeeService.getEmployees()).thenReturn(employees);

        mockMvc.perform(get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username", is("joffry")))
                .andExpect(jsonPath("$[0].name", is("Joffry Ferrater")))
                .andExpect(jsonPath("$[0].manager", is("Jolly Jae Ompod")));
    }
}