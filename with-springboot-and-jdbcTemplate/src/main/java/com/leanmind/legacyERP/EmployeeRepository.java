package com.leanmind.legacyERP;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    public EmployeeRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees;", getEmployeeRowMapper());
    }

    private RowMapper<Employee> getEmployeeRowMapper(){
        return (rs, rowNum) -> new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("status"));
    }
}
