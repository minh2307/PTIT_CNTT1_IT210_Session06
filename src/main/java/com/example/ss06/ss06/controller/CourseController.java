package com.example.ss06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CourseController {
    @Autowired
    private CourseService courseService;

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
