package com.abhi.webservices.myrestwebservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abhinav on 2/7/2019.
 */
@RestController
public class HelloWorld {

    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello")
    public String getHelloWorld(){
        return "Hello World !";
    }

}
