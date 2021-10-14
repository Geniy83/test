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

    private final String GET_ALL = "select * from employee";
    private final String GET_EMPLOYEE_ID = "select * from employee where id = ?";

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query(GET_ALL, new EmployeeRowMapper());
    }

    @Override
    public Employee getEmployeeId(Long id) {
        return jdbcTemplate.queryForObject(GET_EMPLOYEE_ID, new EmployeeRowMapper());
    }
}
