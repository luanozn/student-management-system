package com.example.studentmanagementsystem.entities;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String name;

    @Column(length = 255)
    private String description;

    @OneToMany
    private List<Student> students;
}

