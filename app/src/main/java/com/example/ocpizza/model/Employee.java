package com.example.ocpizza.model;

import java.util.List;

public class Employee {
    private int id;
    private List<Order> orderList;
    private String name;
    private String position;
    private String address;
    private String ongoingAction;

    public Employee() {
    }

    public Employee(int id, List<Order> orderList, String name, String position, String address, String ongoingAction) {
        this.id = id;
        this.orderList = orderList;
        this.name = name;
        this.position = position;
        this.address = address;
        this.ongoingAction = ongoingAction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOngoingAction() {
        return ongoingAction;
    }

    public void setOngoingAction(String ongoingAction) {
        this.ongoingAction = ongoingAction;
    }
}
