package com.leanmind.legacyERP.integration;

import com.leanmind.legacyERP.Employee;
import com.leanmind.legacyERP.EmployeeDontFound;
import com.leanmind.legacyERP.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        employees.forEach(employee -> assertThatEmployeeWithId(employee.getId())
                                                                       .hasStatus("working")
                                                                       .doAssert()
        );
    }

    @Test
    @DisplayName("Should retrieve a employee by them id")
    public void should_retrieve_a_employee_by_them_id() {

        Employee employee = repository.find(2);

        assertThatEmployeeWithId(employee.getId())
                .hasName("Pepe")
                .doAssert();
    }

    @Test
    @DisplayName("Don't found a employee")
    public void don_t_found_a_employee() {
        assertThrows(EmployeeDontFound.class, () -> {
            repository.find(42);
        });
    }
}
