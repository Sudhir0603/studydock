package com.library.study_library_system.controller;

import com.library.study_library_system.entity.Payment;
import com.library.study_library_system.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/student/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/upload")
    public String uploadPage(Model model) {

        model.addAttribute("payment", new Payment());

        return "payment-upload";
    }

    @PostMapping("/save")
    public String uploadPayment(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute Payment payment) throws IOException {

        String uploadDir = "uploads/payments/";

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        file.transferTo(new File(uploadDir + fileName));

        payment.setScreenshotPath(uploadDir + fileName);
        payment.setPaymentStatus("PENDING");
        payment.setUploadedAt(LocalDateTime.now());

        paymentService.savePayment(payment);

        return "redirect:/dashboard";
    }
}