package com.library.study_library_system.repository;


import com.library.study_library_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
