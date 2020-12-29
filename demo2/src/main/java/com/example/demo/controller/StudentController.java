package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/query")
    public Student findOne(@Param("name") String name) {
        return studentService.findStudentByName(name);
    }

    @RequestMapping("/all")
    public List<Student> findAll() {
        return studentService.findAllStudents();
    }
}
