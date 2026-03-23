package com.library.study_library_system.controller;

import com.library.study_library_system.entity.Student;
import com.library.study_library_system.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {

        model.addAttribute("students", studentService.getAllStudents());

        return "student-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("student", new Student());

        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/admin/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return "redirect:/admin/students";
    }
}