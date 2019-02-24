package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.model.StudentName;
import com.abhi.webservices.myrestwebservice.model.StudentV1;
import com.abhi.webservices.myrestwebservice.model.StudentV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abhinav on 2/24/2019.
 */
@RestController
public class StudentVersioning {

    @GetMapping("/student/v1")
    public StudentV1 getStudentNameV1(){
        return new StudentV1("Test versioning");
    }

    @GetMapping("/student/v2")
    public StudentV2 getStudentNameV2(){
        return new StudentV2(new StudentName("Test", "Versioning"));
    }

    @GetMapping(value="/student/param", params="version=1")
    public StudentV1 getStudentNameByParamV1(){
        return new StudentV1("Test versioning");
    }

    @GetMapping(value="/student/param", params = "version=2")
    public StudentV2 getStudentNameByParamV2(){
        return new StudentV2(new StudentName("Test", "Versioning"));
    }

    @GetMapping(value="/student/header", headers ="x-api-version=1")
    public StudentV1 getStudentNameByHeaderV1(){
        return new StudentV1("Test versioning");
    }

    @GetMapping(value="/student/header", headers = "x-api-version=2")
    public StudentV2 getStudentNameByHeaderV2(){
        return new StudentV2(new StudentName("Test", "Versioning"));
    }

    @GetMapping(value="/student/produces", produces ="application/vnd.company.app-v1+json")
    public StudentV1 getStudentNameByProducesV1(){
        return new StudentV1("Test versioning");
    }

    @GetMapping(value="/student/produces", produces = "application/vnd.company.app-v2+json")
    public StudentV2 getStudentNameByProducesV2(){
        return new StudentV2(new StudentName("Test", "Versioning"));
    }

}
