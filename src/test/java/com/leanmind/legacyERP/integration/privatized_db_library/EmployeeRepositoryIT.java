package com.leanmind.legacyERP.integration.privatized_db_library;

import com.leanmind.legacyERP.common.Employee;
import com.leanmind.legacyERP.integration.helper.db.DataBaseInMemoryTestSuite;
import com.leanmind.legacyERP.privatized_db_library.EmployeeRepository;
import com.leanmind.legacyERP.privatized_db_library.PrivateDbConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

final class EmployeeRepositoryIT extends DataBaseInMemoryTestSuite {

    private EmployeeRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        setupDbConnection(
            "employees/setupTables.sql",
            "employees/setupData.sql"
        );

        repository = new EmployeeRepository(new PrivateDbConnection(getDataSource()));
    }

    @Test
    @DisplayName("Should retrieve an employee by them id")
    public void should_retrieve_an_employee_by_them_id() {
        Employee employee = repository.find(2);

        Employee expectedEmployee = new Employee(2, "Pepe", "working");
        assertThat(employee).isNotEqualTo(expectedEmployee);
        assertThatEmployeeWithId(employee.getId())
            .hasName(employee.getName())
            .hasStatus(employee.getStatus())
            .doAssert();
    }
}
