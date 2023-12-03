package com.example.studentmanagementsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Professor extends User implements Serializable {

    @Column (nullable = false,  length = 30)
    private String degree;

    @Column (nullable = false,  length = 30)
    private String postgraduate;

}
