package com.example.studentmanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student Management System", version = "1", description = "API developed for managing the scholar environment"))
public class StudentManagementSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentManagementSystemApplication.class, args);

    }

}
