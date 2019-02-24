package com.abhi.webservices.myrestwebservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abhinav on 2/24/2019.
 */
@JsonIgnoreProperties(value = {"email"})
public class PersonalDtl {
    private String name;
    private String age;
    private String email;
    @JsonIgnore
    private String uid;

    public PersonalDtl(String name, String age, String email, String uid) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
