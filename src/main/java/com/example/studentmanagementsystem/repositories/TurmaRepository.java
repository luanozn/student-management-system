package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {


}
