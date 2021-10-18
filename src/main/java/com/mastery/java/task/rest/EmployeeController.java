package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeId(employeeId);
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/add";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") Long employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeId(employeeId));
        return "employee/update";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.delete(employeeId);
    }
}
