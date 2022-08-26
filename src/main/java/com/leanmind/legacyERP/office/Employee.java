package com.leanmind.legacyERP.office;

public final class Employee {
    private final int id;
    private final String name;
    private final String status;

    public Employee(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getStatus() {return status;}
}
