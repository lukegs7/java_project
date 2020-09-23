package me.geshuai.demo.repoistory.imp;

import me.geshuai.demo.entity.Student;
import me.geshuai.demo.repoistory.StudentRepoistory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepoistoryImpl implements StudentRepoistory {
    private final static Map<Long, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L, new Student(1L, "zhangsan", 22));
        studentMap.put(2L, new Student(2L, "lisi", 21));
        studentMap.put(3L, new Student(3L, "wangwu", 23));
    }

    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
