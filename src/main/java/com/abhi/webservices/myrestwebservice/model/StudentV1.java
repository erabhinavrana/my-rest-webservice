package com.abhi.webservices.myrestwebservice.model;

/**
 * Created by Abhinav on 2/24/2019.
 */
public class StudentV1 {
    private String name;

    public StudentV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
