package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID> {

    Optional<Professor> findByNome(String nome);

    List<Professor> findByEspecialidade(String especialidade);

}

