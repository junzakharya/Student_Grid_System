package com.example.student_grid_system;

import com.example.student_grid_system.StudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //this will return Page<student> of pageNumber "page" with number of students "size"
    public Page<Student> getStudents(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return studentRepository.findAll(pageable);
    }

    public Page<Student> filterStudents(int page, int size, Integer std, String classTeacher, Integer totalMarks){

        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findFilteredStudents(std, classTeacher, totalMarks, pageable);
    }
}