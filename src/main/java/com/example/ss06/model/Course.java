package com.example.ss06.model;

public class Course {
    private String id;
    private String name;
    private double tuitionFee;
    private String startDate;

    public Course() {
    }

    public Course(String id, String name, double tuitionFee, String startDate) {
        this.id = id;
        this.name = name;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}