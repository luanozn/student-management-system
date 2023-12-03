package com.example.studentmanagementsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Administrator extends User implements Serializable {

    @Column(nullable = false,  length = 30)
    private String degree;

}
