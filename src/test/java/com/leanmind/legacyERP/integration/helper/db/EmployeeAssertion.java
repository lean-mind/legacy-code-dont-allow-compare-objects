package com.leanmind.legacyERP.integration.helper.db;

import com.leanmind.legacyERP.office.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public final class EmployeeAssertion {

    private final int id;

    private JdbcTemplate jdbcTemplate;

    private final Map<String, String> fieldsValuesMap;
    EmployeeAssertion(int id, DataSource dataSource) {
        this.id = id;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        fieldsValuesMap = new HashMap<>();
    }

    public EmployeeAssertion hasName(String name) {
        fieldsValuesMap.put("name", name);
        return this;
    }

    public EmployeeAssertion hasStatus(String status) {
        fieldsValuesMap.put("status", status);
        return this;
    }

    public void doAssert() {
        try {
            assertEmployee();
        } catch (AssertionError assertionError) {
            throw assertionError;
        } catch (Exception unexpectedError) {
            throw new AssertionError("Unexpected Error inside employee assert", unexpectedError);
        }
    }

    private void assertEmployee() {
        StringBuilder sql = new StringBuilder(500).append("SELECT id");
        for (String field : fieldsValuesMap.keySet()) {
            sql.append(", ").append(field);
        }
        sql
                .append(" FROM employees")
                .append(" WHERE id = ").append(id);

        List<Employee> employees = jdbcTemplate.query(sql.toString(), (rs, rowNum) -> {
            for (Map.Entry<String, String> entry : fieldsValuesMap.entrySet()) {
                String field = entry.getKey();
                String value = rs.getString(field);
                String expected = entry.getValue();
                assertThat(value).withFailMessage("Wrong value for field '%s'. Expected is '%s' but actual was '%s'",
                                                  field,
                                                  expected,
                                                  value)
                        .isEqualTo(expected);
            }
            return null; // Only it's necessary iterate through rows, don't need to return the object
        });

        if (employees.isEmpty()){
            fail("Employee with ID '%s' not found", id);
        }
    }
}
