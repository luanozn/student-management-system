package com.example.studentmanagementsystem.entities.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    PROFESSOR("professor"),
    STUDENT("student"),
    ADMIN("admin");

    private final String role;

    UserRole(String role){
        this.role = role;
    }
}
