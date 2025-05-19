package com.keyin.store;

public class Employee {
    private int employeeIdd;
    private String name;
    private String position;

    public Employee(int employeeIdd, String name, String position) {
        this.employeeIdd = employeeIdd;
        this.name = name;
        this.position = position;
    }

    public Employee() {
    }

    public int getEmployeeIdd() {
        return employeeIdd;
    }

    public void setEmployeeIdd(int employeeIdd) {
        this.employeeIdd = employeeIdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
