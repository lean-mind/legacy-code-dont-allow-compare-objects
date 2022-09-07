package com.leanmind.legacyERP.privatized_db_library;

import com.leanmind.legacyERP.common.Employee;

public class TrickedEmployee extends Employee {

    public TrickedEmployee(int id, String name, String status) {
        super(id, name, status);
    }

    @Override()
    public int hashCode() {
        return Integer.parseInt(String.valueOf(Math.random()));
    }
}
