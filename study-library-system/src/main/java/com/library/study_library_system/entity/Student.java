package com.library.study_library_system.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String seatNumber;

    private LocalDate joinDate;

    private LocalDate subscriptionExpiry;

    private String libraryPlan;

    private Double monthlyFee;

    private Boolean status;
}