package com.leanmind.legacyERP.integration.open_db_library;

import com.leanmind.legacyERP.integration.helper.db.DataBaseInMemoryTestSuite;
import com.leanmind.legacyERP.open_db_library.Employee;
import com.leanmind.legacyERP.open_db_library.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Should retrieve an employee by them id")
    public void should_retrieve_an_employee_by_them_id() {
        Employee employee = repository.find(2);

        Employee expectedEmployee = new Employee(2, "Pepe", "working");
        assertThat(employee).isEqualTo(expectedEmployee);
    }
}
