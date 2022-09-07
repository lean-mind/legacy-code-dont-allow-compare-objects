package com.leanmind.legacyERP.privatized_db_library;

import com.leanmind.legacyERP.common.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class PrivateDbConnection {
    private final JdbcTemplate jdbcTemplate;

    public PrivateDbConnection(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> query() {
        return jdbcTemplate.query("SELECT * FROM employees;", getEmployeeRowMapper());
    }

    private RowMapper<Employee> getEmployeeRowMapper() {
        return (rs, rowNum) -> new TrickedEmployee(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("status")
        );
    }
}
