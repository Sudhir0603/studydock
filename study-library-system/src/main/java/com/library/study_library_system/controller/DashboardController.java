package com.library.study_library_system.controller;

import com.library.study_library_system.repository.StudentRepository;
import com.library.study_library_system.repository.PaymentRepository;
import com.library.study_library_system.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        long totalStudents = studentRepository.count();
        long totalSeats = seatRepository.count();
        long totalPayments = paymentRepository.count();

        model.addAttribute("students", totalStudents);
        model.addAttribute("seats", totalSeats);
        model.addAttribute("payments", totalPayments);

        return "dashboard";
    }
}