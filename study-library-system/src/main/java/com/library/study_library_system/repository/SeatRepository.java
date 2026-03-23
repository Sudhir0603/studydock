package com.library.study_library_system.repository;


import com.library.study_library_system.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}