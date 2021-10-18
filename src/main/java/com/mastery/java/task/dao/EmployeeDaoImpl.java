package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.rowMapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Employee> getAll() {
        String SQL = "SELECT * FROM employee";
        return jdbcTemplate.query(SQL, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeId(Long employeeId) {
        String SQL = "SELECT * FROM employee WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(SQL, new EmployeeRowMapper(), employeeId);
    }

    @Override
    public void save(Employee employee) {
        String SQL = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, data_of_birth) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentID(), employee.getJobTitle(), employee.getGender().toString(), employee.getDataOfBirth());
    }

    @Override
    public void update(Employee employee) {
        String SQL = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, data_of_birth=? WHERE employee_id=?";
        jdbcTemplate.update(SQL, employee.getFirstName(), employee.getLastName(), employee.getDepartmentID(),
                employee.getJobTitle(), employee.getGender().toString(), employee.getDataOfBirth(), employee.getEmployeeId());
    }

    @Override
    public void delete(Long employeeId) {
        String SQL = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(SQL, employeeId);
    }
}
