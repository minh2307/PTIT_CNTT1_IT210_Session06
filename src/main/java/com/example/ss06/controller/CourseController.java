package com.example.ss06.controller;

import com.example.ss06.model.Course;
import com.example.ss06.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // ===== LIST =====
    @GetMapping("/list")
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

    // ===== DETAIL =====
    @GetMapping("/detail/{courseCode}")
    public String getCourseDetail(@PathVariable String courseCode, Model model) {

        Course course = courseService.findByCourseCode(courseCode);

        if (course == null) {
            model.addAttribute("message", "Không tìm thấy khóa học!");
            return "course/detail";
        }

        model.addAttribute("course", course);
        return "course/detail";
    }

    // ===== EDIT (GET) =====
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {

        Course course = courseService.findById(id);

        if (course == null) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course/edit";
    }

    // ===== EDIT (POST) =====
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
