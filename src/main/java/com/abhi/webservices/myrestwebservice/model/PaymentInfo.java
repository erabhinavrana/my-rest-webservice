package com.abhi.webservices.myrestwebservice.model;


import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * Created by Abhinav on 2/24/2019.
 */
@JsonFilter("paymentInfoFilter")
public class PaymentInfo {
    private int id;
    private double amount;
    private String cardNo;

    public PaymentInfo(int id, double amount, String cardNo) {
        this.id = id;
        this.amount = amount;
        this.cardNo = cardNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
