package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.ActivityResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActivityResultRepository extends JpaRepository<ActivityResult, UUID> {

}
