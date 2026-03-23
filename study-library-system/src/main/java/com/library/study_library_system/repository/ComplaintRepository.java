package com.library.study_library_system.repository;

import com.library.study_library_system.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}