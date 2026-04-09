package com.example.ss06.repository;

import com.example.ss06.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1, "IELTS-6.5", "IELTS 6.5", "Intermediate", 5000000.0, "2026-05-01", "Lộ trình IELTS 6.5", "Mr. A", "3 months", 10, false, "ACTIVE"));
        courses.add(new Course(2, "IELTS-7.0", "IELTS 7.0", "Advanced", 7000000.0, "2026-06-01", "Lộ trình IELTS 7.0", "Ms. B", "4 months", 0, false, "ACTIVE"));
        courses.add(new Course(3, "BASIC-ENG", "Basic English", "Beginner", 3000000.0, "2026-04-20", "Tiếng Anh cơ bản", "Mr. C", "2 months", 5, false, "ACTIVE"));
        courses.add(new Course(4, "COMM-ENG", "Communication", "Intermediate", 4000000.0, "2026-05-15", "Giao tiếp", "Ms. D", "2.5 months", 0, false, "ACTIVE"));
        courses.add(new Course(5, "ADV-GRAM", "Advanced Grammar", "Advanced", 6000000.0, "2026-06-10", "Ngữ pháp nâng cao", "Mr. E", "3 months", 2, false, "ACTIVE"));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findByCourseCode(String courseCode) {
        return courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(courseCode))
                .findFirst()
                .orElse(null);
    }

    public Course findById(Integer id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findByLevel(String level) {
        return courses.stream()
                .filter(c -> c.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }

    public List<Course> findByMaxFee(Double maxFee) {
        return courses.stream()
                .filter(c -> c.getTuitionFee() <= maxFee)
                .collect(Collectors.toList());
    }

    public void update(Course updatedCourse) {
        for (Course c : courses) {
            if (c.getId().equals(updatedCourse.getId())) {
                c.setTuitionFee(updatedCourse.getTuitionFee());
                c.setStartDate(updatedCourse.getStartDate());
                break;
            }
        }
    }

    public void delete(Integer id) {
        courses.removeIf(c -> c.getId().equals(id));
    }
}