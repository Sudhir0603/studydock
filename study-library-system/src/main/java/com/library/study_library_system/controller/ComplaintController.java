package com.library.study_library_system.controller;

import com.library.study_library_system.entity.Complaint;
import com.library.study_library_system.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping("/student/complaint")
    public String complaintPage(Model model) {

        model.addAttribute("complaint", new Complaint());

        return "complaint-form";
    }

    @PostMapping("/student/complaint/save")
    public String saveComplaint(@ModelAttribute Complaint complaint) {

        complaint.setStatus("PENDING");
        complaint.setCreatedAt(LocalDateTime.now());

        complaintService.saveComplaint(complaint);

        return "redirect:/dashboard";
    }
}