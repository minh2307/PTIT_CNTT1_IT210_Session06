package com.example.ss06.controller;

import com.example.ss06.model.Course;
import com.example.ss06.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // ===== GET: Hiển thị form sửa =====
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Course course = courseService.findById(id);

        if (course == null) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course/edit";
    }

    // ===== POST: Xử lý update =====
    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable String id,
                               @ModelAttribute("course") Course course) {

        Course existingCourse = courseService.findById(id);

        if (existingCourse != null) {
            existingCourse.setTuitionFee(course.getTuitionFee());
            existingCourse.setStartDate(course.getStartDate());

            courseService.update(existingCourse);
        }

        // PRG Pattern
        return "redirect:/course/list";
    }
}