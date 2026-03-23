package com.library.study_library_system.controller;

import com.library.study_library_system.entity.Payment;
import com.library.study_library_system.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/payments")
public class AdminPaymentController {

    private final PaymentService paymentService;

    public AdminPaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String viewPayments(Model model) {

        model.addAttribute("payments", paymentService.getAllPayments());

        return "payment-list";
    }

    @GetMapping("/approve/{id}")
    public String approvePayment(@PathVariable Long id) {

        Payment payment = paymentService.getPaymentById(id);

        payment.setPaymentStatus("APPROVED");

        paymentService.savePayment(payment);

        return "redirect:/admin/payments";
    }

    @GetMapping("/reject/{id}")
    public String rejectPayment(@PathVariable Long id) {

        Payment payment = paymentService.getPaymentById(id);

        payment.setPaymentStatus("REJECTED");

        paymentService.savePayment(payment);

        return "redirect:/admin/payments";
    }
}