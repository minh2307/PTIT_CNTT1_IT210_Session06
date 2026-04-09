package com.example.ss06.controller;

import com.example.ss06.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;

public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/course/list")
    public String listCourses(
            @RequestParam(defaultValue = "ALL") String level,
            @RequestParam(defaultValue = "999999999") double maxFee,
            Model model) {

        List<Course> courses = courseService.filterCourses(level, maxFee);

        model.addAttribute("courses", courses);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxFee", maxFee);

        return "course/list";
    }

    // 🔹 Người 5 làm đoạn này
    @GetMapping("/course/detail/{courseCode}")
    public String getCourseDetail(@PathVariable String courseCode, Model model) {

        Course course = courseService.findByCourseCode(courseCode);

        // xử lý nếu không tìm thấy
        if (course == null) {
            model.addAttribute("message", "Không tìm thấy khóa học!");
            return "course/detail";
        }

        model.addAttribute("course", course);
        return "course/detail";
    }

}
