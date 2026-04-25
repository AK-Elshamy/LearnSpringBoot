package com.cwe.crud;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Staff {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Title is required")
    private String title;
    private double salary;
    private String id;

    public Staff(String name, String title, double salary, String id) {
        this.name = name;
        this.title = title;
        this.salary = salary;
        this.id = id;
    }

    public Staff() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
