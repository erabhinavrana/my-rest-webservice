package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.responsebean.ServiceResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/hello-bean")
    public ServiceResponseBean getHelloWorldBean(){
        return new ServiceResponseBean("Hello World");
    }

    @GetMapping(path = "/hello-bean/pathvar/{message}")
    public ServiceResponseBean getHelloWorldByPathVariable(@PathVariable String message){
        return new ServiceResponseBean(message);
    }

}
