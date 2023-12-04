package com.example.studentmanagementsystem.entities.dto;

import com.example.studentmanagementsystem.entities.enums.UserRole;
import lombok.Getter;

@Getter
public class RegisterDTO {

    private final String registration;
    private final String email;
    private final String name;
    private final String password;
    private final UserRole role;

    private RegisterDTO(String registration, String password, String email, String name, UserRole role) {
        this.registration = registration;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public static RegisterDTO create(String registration, String password, String email, String name, UserRole role) {
        return new RegisterDTO(registration, password, email, name, role);
    }
}
