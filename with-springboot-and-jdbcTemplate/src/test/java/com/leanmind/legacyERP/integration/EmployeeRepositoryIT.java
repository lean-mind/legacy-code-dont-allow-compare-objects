package com.leanmind.legacyERP.integration;

import com.leanmind.legacyERP.Employee;
import com.leanmind.legacyERP.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class EmployeeRepositoryIT extends DataBaseInMemoryTestSuite {

    private EmployeeRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        setupDbConnection(
                "employees/setupTables.sql",
                "employees/setupData.sql"
        );

        repository = new EmployeeRepository(getDataSource());
    }

    @Test
    @DisplayName("Should retrieve all employees")
    public void should_retrieve_all_employees() {

        List<Employee> employees = repository.findAll();

        assertThat(employees).isNotEmpty();
        employees.forEach(employee -> assertThat(employee.getName()).isEqualTo("Pepe"));
    }
}
