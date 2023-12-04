package com.example.studentmanagementsystem.entities;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Room {

    @Id
    private Long id;

    @Column(nullable = false, length = 50)
    private String roomName;

    @Column(nullable = false)
    private boolean availability;

    @Column(nullable = false)
    private int roomNumber;

}

