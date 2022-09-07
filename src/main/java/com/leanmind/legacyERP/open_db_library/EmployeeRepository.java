package com.leanmind.legacyERP.open_db_library;

import com.leanmind.legacyERP.common.Employee;
import com.leanmind.legacyERP.common.EmployeeDontFound;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public final class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Employee find(int id) {
        return findAll().stream().filter(employee -> employee.getId() == id).findFirst().orElseThrow(() -> new EmployeeDontFound(id));
    }

    private List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employees;", getEmployeeRowMapper());
    }


    private RowMapper<Employee> getEmployeeRowMapper(){
        return (rs, rowNum) -> new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("status"));
    }
}
