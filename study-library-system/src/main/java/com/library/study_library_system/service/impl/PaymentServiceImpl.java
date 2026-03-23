package com.library.study_library_system.service.impl;

import com.library.study_library_system.entity.Payment;
import com.library.study_library_system.repository.PaymentRepository;
import com.library.study_library_system.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}