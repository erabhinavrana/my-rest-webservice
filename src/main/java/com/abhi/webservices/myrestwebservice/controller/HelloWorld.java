package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.responsebean.ServiceResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * Created by Abhinav on 2/7/2019.
 */
@RestController
public class HelloWorld {

    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;
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

    @GetMapping(path = "/hello/internationalized1")
    public String getHelloWorldInternationalize(@RequestHeader(value = "Accept-Language", required = false)Locale locale){
        return resourceBundleMessageSource.getMessage("good.morning.message",null, locale);
    }

    @GetMapping(path = "/hello/internationalized2")
    public String getHelloWorldInternationalized(){
        return resourceBundleMessageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
