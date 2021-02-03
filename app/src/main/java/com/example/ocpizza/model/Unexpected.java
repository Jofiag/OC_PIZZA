package com.example.ocpizza.model;

public class Unexpected {
    private int id;
    private String situationDescription;
    private int employeeId;

    public Unexpected() {
    }

    public Unexpected(int id, String situationDescription, int employeeId) {
        this.id = id;
        this.situationDescription = situationDescription;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituationDescription() {
        return situationDescription;
    }

    public void setSituationDescription(String situationDescription) {
        this.situationDescription = situationDescription;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
