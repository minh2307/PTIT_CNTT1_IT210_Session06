package com.example.ss06.service;

import com.example.ss06.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course("C01", "IELTS 5.0", 5000000, "2026-05-01"));
        courses.add(new Course("C02", "IELTS 6.5", 7000000, "2026-06-01"));
        courses.add(new Course("C03", "TOEIC 600", 4000000, "2026-04-20"));
    }

    public Course findById(String id) {
        for (Course c : courses) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public void update(Course course) {
        // Không cần làm gì vì đã update trực tiếp object
    }

    public List<Course> findAll() {
        return courses;
    }
}