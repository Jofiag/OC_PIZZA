package com.example.ocpizza.model;

import java.util.List;

public class Order {
    private int id;
    private List<String> pizzaList;
    private String recoveryMode;
    private String paymentMode;
    private String status;

    public Order() {
    }

    public Order(int id, List<String> pizzaList, String recoveryMode, String paymentMode, String status) {
        this.id = id;
        this.pizzaList = pizzaList;
        this.recoveryMode = recoveryMode;
        this.paymentMode = paymentMode;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<String> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public String getRecoveryMode() {
        return recoveryMode;
    }

    public void setRecoveryMode(String recoveryMode) {
        this.recoveryMode = recoveryMode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
