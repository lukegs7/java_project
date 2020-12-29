package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void insertStudent(String name, Integer age) {
        studentDao.insertStudent(name, age);
    }

    public void updateStudent(Integer id, String name) {
        studentDao.updateStudent(id, name);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAllStudent();
    }

    public Student findStudentByName(String name) {
        return studentDao.findStudentByName(name);
    }
}
