package com.abhi.webservices.myrestwebservice.model;

/**
 * Created by Abhinav on 2/24/2019.
 */
public class StudentV2 {
    private StudentName name;

    public StudentV2(StudentName name) {
        this.name = name;
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }
}
