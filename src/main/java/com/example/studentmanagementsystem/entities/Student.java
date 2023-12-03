package com.example.studentmanagementsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Student extends User implements Serializable {

    @Column(nullable = false,  length = 50)
    private String motherName;

    @Column (nullable = false,  length = 50)
    private String fatherName;

}
