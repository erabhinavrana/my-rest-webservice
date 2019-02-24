package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.model.PersonalDtl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abhinav on 2/24/2019.
 */
@RestController
public class StaticFiltering {

    @GetMapping("/filter")
    public PersonalDtl filteredData(){
        return new PersonalDtl("Test", "21", "xyz@test.com","QWERT");
    }
}
