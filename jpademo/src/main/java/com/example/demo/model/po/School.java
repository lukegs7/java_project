package com.example.demo.model.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;

}
