package com.example.student_grid_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudents") //Load Student Details API
    public Page<Student> getStudents(@RequestParam int page, @RequestParam int size){

        return studentService.getStudents(page, size);
    }

    @GetMapping("/filterStudents") //Server-side Filtering API
    public Page<Student> filterStudents(@RequestParam int page,
                                        @RequestParam int size,
                                        @RequestParam Integer std,
                                        @RequestParam String classTeacher,
                                        @RequestParam Integer totalMarks){

        return studentService.filterStudents(page, size, std, classTeacher, totalMarks);
    }
}