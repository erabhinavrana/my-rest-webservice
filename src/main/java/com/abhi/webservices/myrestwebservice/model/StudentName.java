package com.abhi.webservices.myrestwebservice.model;

/**
 * Created by Abhinav on 2/24/2019.
 */
public class StudentName {
    private String firstName;
    private String lastName;

    public StudentName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
