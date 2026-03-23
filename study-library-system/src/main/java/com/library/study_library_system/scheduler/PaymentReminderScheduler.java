package com.library.study_library_system.scheduler;

import com.library.study_library_system.repository.StudentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PaymentReminderScheduler {

    private final StudentRepository studentRepository;

    public PaymentReminderScheduler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void checkPayments() {

        int day = LocalDate.now().getDayOfMonth();

        if(day == 6) {

            System.out.println("Sending payment reminder to students...");

        }

        if(day == 10) {

            System.out.println("Sending payment warning...");

        }

        if(day == 15) {

            System.out.println("Locking unpaid seats...");

        }

    }
}