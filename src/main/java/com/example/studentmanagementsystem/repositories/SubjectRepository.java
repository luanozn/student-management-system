package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {


}
