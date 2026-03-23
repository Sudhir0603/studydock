package com.library.study_library_system.controller;

import com.library.study_library_system.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/admin/seats")
    public String seatLayout(Model model) {

        model.addAttribute("seats", seatRepository.findAll());

        return "seat-layout";
    }
}