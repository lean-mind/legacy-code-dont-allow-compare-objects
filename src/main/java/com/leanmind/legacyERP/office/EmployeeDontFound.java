package com.leanmind.legacyERP.office;

public class EmployeeDontFound extends RuntimeException {

    public EmployeeDontFound(int id) {
        super(String.format("Employee with %d don't found", id));
    }
}
