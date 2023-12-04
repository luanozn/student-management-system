package com.example.studentmanagementsystem.entities.dto;

import lombok.Getter;

@Getter
public class AuthenticationDTO {

    private final String registration;
    private final String password;

    private AuthenticationDTO(String registration, String password){
        this.registration = registration;
        this.password = password;
    }

    public static AuthenticationDTO create(String registration, String password){
        return new AuthenticationDTO(registration, password);
    }

}
