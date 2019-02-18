package com.abhi.webservices.myrestwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

/**
 * Created by Abhinav on 2/18/2019.
 */
@ControllerAdvice
@RestController
public class EmployeeException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<EmployeeError> handleAllExceptions(Exception ex, WebRequest rq){
        return new ResponseEntity(new EmployeeError("EMP-0001", "System error !!", Arrays.toString(ex.getStackTrace())), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<EmployeeError> handleEmployeeNotFoundExceptions(EmployeeNotFoundException ex, WebRequest rq){
        return new ResponseEntity(new EmployeeError("EMP-0002", "Employee record not found.", Arrays.toString(ex.getStackTrace())), HttpStatus.NOT_FOUND);
    }
}
