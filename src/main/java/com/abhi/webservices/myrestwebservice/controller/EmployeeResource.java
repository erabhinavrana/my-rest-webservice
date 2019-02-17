package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.dao.EmployeeDAO;
import com.abhi.webservices.myrestwebservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeDAO employeeDAOService;

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeDAOService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable final int id){
        return employeeDAOService.findOne(id);
    }

//    @PostMapping("/employees")
//    public Employee saveEmployee(@RequestBody final Employee employee){
//        return employeeDAOService.save(employee);
//    }

    @PostMapping("/employees")
    public ResponseEntity saveEmployee(@RequestBody final Employee employee){

        Employee savedEmployee = employeeDAOService.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).body(savedEmployee);
    }

}
