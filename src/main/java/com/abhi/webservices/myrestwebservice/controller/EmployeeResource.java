package com.abhi.webservices.myrestwebservice.controller;

import com.abhi.webservices.myrestwebservice.dao.EmployeeDAO;
import com.abhi.webservices.myrestwebservice.exception.EmployeeNotFoundException;
import com.abhi.webservices.myrestwebservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
        return Optional.ofNullable(employeeDAOService.findOne(id)).orElseThrow(() -> new EmployeeNotFoundException("ID-"+id));
    }

//    @PostMapping("/employees")
//    public Employee saveEmployee(@RequestBody final Employee employee){
//        return employeeDAOService.save(employee);
//    }

    @PostMapping("/employees")
    public ResponseEntity saveEmployee(@Valid @RequestBody final Employee employee){

        Employee savedEmployee = employeeDAOService.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).body(savedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployeeById(@PathVariable final int id){
        return Optional.ofNullable(employeeDAOService.deleteById(id)).orElseThrow(() -> new EmployeeNotFoundException("ID-"+id));
    }

}
