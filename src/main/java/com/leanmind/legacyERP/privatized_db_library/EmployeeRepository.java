package com.leanmind.legacyERP.privatized_db_library;

import com.leanmind.legacyERP.common.EmployeeDontFound;

import java.util.List;

public final class EmployeeRepository {

    private final PrivateDbConnection privateDbConnection;

    public EmployeeRepository(PrivateDbConnection privateDbConnection) {
        this.privateDbConnection = privateDbConnection;
    }

    public Employee find(int id) {
        return findAll().stream().filter(employee -> employee.getId() == id).findFirst().orElseThrow(() -> new EmployeeDontFound(id));
    }

    private List<Employee> findAll() {
        return privateDbConnection.query();
    }
}
