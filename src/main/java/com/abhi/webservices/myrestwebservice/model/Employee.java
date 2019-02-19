package com.abhi.webservices.myrestwebservice.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


public class Employee {
    private Integer id;
    @NotNull
    @Size(min = 3)
    private String name;
    @NotNull
    @Size(min = 3, max = 15)
    private String designation;
    @Past
    private LocalDate dateOfBirth;

    public Employee(Integer id, String name, String designation, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
