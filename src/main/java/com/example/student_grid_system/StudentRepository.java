package com.example.student_grid_system;

import com.example.student_grid_system.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM students WHERE (:std IS NULL OR std = :std) AND (:classTeacher IS NULL OR class_teacher = :classTeacher) AND (:totalMarks IS NULL OR total_marks = :totalMarks)",
            nativeQuery = true)
    Page<Student> findFilteredStudents(@Param("std") Integer std, @Param("classTeacher") String classTeacher, @Param("totalMarks") Integer totalMarks, Pageable pageable);
}