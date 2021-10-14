package com.mastery.java.task.rowMapper;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong(1));
        employee.setFirstName(resultSet.getString(2));
        employee.setLastName(resultSet.getString(3));
        employee.setDepartmentID(resultSet.getInt(4));
        employee.setJobTitle(resultSet.getString(5));
        employee.setGender(Gender.valueOf(resultSet.getString(6)));
        employee.setDataOfBirth(resultSet.getDate(7));
        return employee;
    }
}
