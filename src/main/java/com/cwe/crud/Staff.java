package com.cwe.crud;

public class Staff {
    private String name;
    private String title;
    private double salary;

    public Staff(String name, String title, double salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public Staff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
