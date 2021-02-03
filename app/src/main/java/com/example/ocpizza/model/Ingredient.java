package com.example.ocpizza.model;

public class Ingredient {
    private String name;
    private int quantity;
    private int managerId;

    public Ingredient() {
    }

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient(String name, int quantity, int managerId) {
        this.name = name;
        this.quantity = quantity;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
