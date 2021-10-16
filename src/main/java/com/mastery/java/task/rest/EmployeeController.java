package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
