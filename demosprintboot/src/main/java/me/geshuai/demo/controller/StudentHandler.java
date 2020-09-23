package me.geshuai.demo.controller;

import me.geshuai.demo.entity.Student;
import me.geshuai.demo.repoistory.StudentRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private StudentRepoistory studentRepoistory;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return studentRepoistory.findAll();
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        return studentRepoistory.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepoistory.saveOrUpdate(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentRepoistory.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        studentRepoistory.deleteById(id);
    }
}
