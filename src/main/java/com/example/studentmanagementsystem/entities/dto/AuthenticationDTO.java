package com.example.studentmanagementsystem.entities.dto;

import lombok.Getter;

@Getter
public class AuthenticationDTO {

    private final String login;
    private final String password;

    private AuthenticationDTO(String login, String password){
        this.login = login;
        this.password = password;
    }

    public static AuthenticationDTO create(String login, String password){
        return new AuthenticationDTO(login, password);
    }

}
