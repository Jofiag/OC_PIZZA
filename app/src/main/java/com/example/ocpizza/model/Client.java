package com.example.ocpizza.model;

public class Client {
    private int id;
    private int orderId;
    private String name;
    private String address;

    public Client() {
    }

    public Client(int id, int orderId, String name, String address) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
