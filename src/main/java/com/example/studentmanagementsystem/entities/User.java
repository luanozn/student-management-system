package com.example.studentmanagementsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (nullable = false, unique = true, length = 16)
    private Long registration;

    @Column (nullable = false, length = 50)
    private String name;

    @Column (nullable = false, unique = true, length = 255)
    private Long email;

    @Column (nullable = false, unique = true, length = 30)
    private Long password;

}
