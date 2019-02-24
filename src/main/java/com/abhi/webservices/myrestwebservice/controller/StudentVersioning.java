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

    @GetMapping("/v1/student")
    public StudentV1 getStudentNameV1(){
        return new StudentV1("Test versioning");
    }

    @GetMapping("/v2/student")
    public StudentV2 getStudentNameV2(){
        return new StudentV2(new StudentName("Test", "Versioning"));
    }
}
