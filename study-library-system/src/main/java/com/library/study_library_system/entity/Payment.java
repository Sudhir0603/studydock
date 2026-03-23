package com.library.study_library_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;

    private Double amount;

    private String screenshotPath;

    private String paymentStatus;

    private LocalDateTime uploadedAt;

}