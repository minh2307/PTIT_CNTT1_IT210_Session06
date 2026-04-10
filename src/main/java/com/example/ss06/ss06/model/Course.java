package com.example.ss06.model;

public class Course {
    private Integer id;
    private String courseCode;
    private String name;
    private String level;
    private Double tuitionFee;
    private String startDate;
    private String description;
    private String teacher;
    private String duration;
    private Integer studentCount;
    private boolean isFull;
    private String status;

    public Course() {
    }

    public Course(Integer id, String courseCode, String name, String level, Double tuitionFee,
                  String startDate, String description, String teacher, String duration,
                  Integer studentCount, boolean isFull, String status) {
        this.id = id;
        this.courseCode = courseCode;
        this.name = name;
        this.level = level;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.description = description;
        this.teacher = teacher;
        this.duration = duration;
        this.studentCount = studentCount;
        this.isFull = isFull;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}