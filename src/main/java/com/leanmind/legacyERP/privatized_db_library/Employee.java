package com.leanmind.legacyERP.privatized_db_library;

public class Employee {
    private final int id;
    private final String name;
    private final String status;

    public Employee(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }


    @Override()
    public int hashCode() {
        return Integer.parseInt(String.valueOf(Math.random()));
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", status='" + status + '\'' +
            '}';
    }
}
