package com.library.study_library_system.repository;

import com.library.study_library_system.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByPaymentStatus(String status);

}