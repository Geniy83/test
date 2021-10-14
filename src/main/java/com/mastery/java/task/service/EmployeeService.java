package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getEmployeeId(Long id);


}
