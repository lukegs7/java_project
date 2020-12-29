package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {
    @Select("select * from student where name= #{name}")
    Student findStudentByName(@Param("name") String name);

    @Select("select * from student")
    List<Student> findAllStudent();

    @Insert("insert into student(name,age) values( #{name}, #{age})")
    void insertStudent(@Param("name") String name, @Param("age") Integer age);

    @Update("update student set name=#{name} where id=#{id}")
    void updateStudent(@Param("id") Integer id, @Param("name") String name);
}
