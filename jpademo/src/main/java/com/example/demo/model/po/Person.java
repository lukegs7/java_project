package com.example.demo.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer age;
    private Long companyId;
    private Long schoolId;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
