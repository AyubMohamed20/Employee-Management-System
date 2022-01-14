package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/addNewEmployeeForm")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) throws IOException {
        java.sql.Date dateOfBirth = employee.getDateOfBirth();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOfBirth);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        dateOfBirth = new Date(cal.getTimeInMillis());
        employee.setDateOfBirth(dateOfBirth);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/updateEmployeeForm/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long employeeId) {
        this.employeeService.deleteEmployeeById(employeeId);
        return "redirect:/";
    }
}
