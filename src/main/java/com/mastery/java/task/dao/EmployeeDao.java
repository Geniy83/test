package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    Employee getEmployeeId(Long employeeId);

    void  save(Employee employee);

    void  update(Employee employee);

    void  delete(Long employeeId);
}
