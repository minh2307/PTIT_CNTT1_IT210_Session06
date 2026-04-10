package com.example.ss06.controller;

import com.example.ss06.model.Course;
import com.example.ss06.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // ===== LIST =====
    @GetMapping("/list")
    public String listCourses(
            @RequestParam(name = "level", defaultValue = "ALL") String level,
            @RequestParam(name = "maxFee", required = false) Double maxFee,
            Model model) {

        List<Course> courses = courseService.filterCourses(level, maxFee);

        model.addAttribute("courses", courses);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxFee", maxFee);

        return "course/list";
    }

    // ===== DETAIL =====
    @GetMapping("/detail/{courseCode}")
    public String getCourseDetail(@PathVariable("courseCode") String courseCode, Model model) {

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
    public String showEditForm(@PathVariable("id") Integer id, Model model) {

        Course course = courseService.findById(id);

        if (course == null) {
            return "redirect:/course/list";
        }

        model.addAttribute("course", course);
        return "course/edit";
    }

    // ===== EDIT (POST) =====
    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable("id") Integer id,
                               @ModelAttribute("course") Course course) {

        Course existingCourse = courseService.findById(id);

        if (existingCourse != null) {
            existingCourse.setTuitionFee(course.getTuitionFee());
            existingCourse.setStartDate(course.getStartDate());
            existingCourse.setStudentCount(course.getStudentCount());

            courseService.update(existingCourse);
        }

        return "/course/list";
    }

    // ===== DELETE (POST) =====
    @PostMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        String result = courseService.deleteCourse(id);
        if (!"Xóa thành công".equals(result)) {
            redirectAttributes.addFlashAttribute("error", result);
        } else {
            redirectAttributes.addFlashAttribute("success", result);
        }
        return "/course/list";
    }
}
