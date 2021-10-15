package com.mastery.java.task.rest;

import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee/all";
    }

    @GetMapping("/{id}")
    public String getEmployeeId(@PathVariable("id") Long employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeId(employeeId));
        return "employee/show";
    }
}
