package com.leanmind.legacyERP.open_db_library;

public final class EmployeeDontFound extends RuntimeException {

    public EmployeeDontFound(int id) {
        super(String.format("Employee with %d don't found", id));
    }
}
