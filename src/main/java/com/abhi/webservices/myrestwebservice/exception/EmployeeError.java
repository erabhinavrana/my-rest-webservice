package com.abhi.webservices.myrestwebservice.exception;

/**
 * Created by Abhinav on 2/18/2019.
 */
public class EmployeeError {
    private String errorCode;
    private String errorMessage;
    private String errorSummary;

    public EmployeeError(String errorCode, String errorMessage, String errorSummary) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorSummary = errorSummary;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorSummary() {
        return errorSummary;
    }

}
