package com.abhi.webservices.myrestwebservice.responsebean;

/**
 * Created by Abhinav on 2/11/2019.
 */
public class ServiceResponseBean {
    private String message;
    public ServiceResponseBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceResponseBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
