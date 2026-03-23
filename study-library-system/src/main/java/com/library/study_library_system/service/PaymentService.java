package com.library.study_library_system.service;

import com.library.study_library_system.entity.Payment;
import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

}