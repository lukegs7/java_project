package me.geshuai.demo.repoistory;

import me.geshuai.demo.entity.Student;

import java.util.Collection;

public interface StudentRepoistory {
    public Collection<Student> findAll();

    public Student findById(long id);

    public void saveOrUpdate(Student student);

    public void deleteById(long id);
}
