package com.abhi.webservices.myrestwebservice.dao;

import com.abhi.webservices.myrestwebservice.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDAO {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Abhi", "Engineer", LocalDate.of(1990,2,5)));
        employees.add(new Employee(2, "Sonu", "Sr. Engineer", LocalDate.of(1988,5,3)));
        employees.add(new Employee(3, "Monu", "Manager", LocalDate.of(1970,3,30)));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee save(Employee employee) {
       return Optional.ofNullable(employee)
                .filter(emp -> !Optional.ofNullable(emp.getId()).isPresent())
                .map(employee1 -> {
                    Employee savedEmployee = new Employee(employees.size()+1, employee.getName(), employee.getDesignation(), employee.getDateOfBirth());
                    employees.add(savedEmployee);
                    return savedEmployee;
                })
                .orElseGet(() -> {
                    employees.add(employee);
                    return employee;
                });
    }

    public Employee findOne(int id){
        return employees.stream()
                .filter(employee -> employee.getId() == id).findAny().orElse(null);
    }
}
