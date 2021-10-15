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
        String SQL = "select * from employee";
        return jdbcTemplate.query(SQL, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeId(Long employeeId) {
        String SQL = "select * from employee where employee_id = ?";
        return jdbcTemplate.queryForObject(SQL, new EmployeeRowMapper(), employeeId);
    }
}
