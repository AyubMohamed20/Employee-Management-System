package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public void deleteEmployeeById(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
