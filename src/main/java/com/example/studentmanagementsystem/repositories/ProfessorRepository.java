package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Professor;
import com.example.studentmanagementsystem.entities.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {

    Optional<Professor> findByName(String name);

    List<Professor> findBySpecialization(Specialization specialization);

}

