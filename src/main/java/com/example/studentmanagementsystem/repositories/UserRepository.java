package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByRegistration(String login);
}
