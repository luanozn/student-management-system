package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, UUID> {
    // Aqui você pode adicionar métodos específicos de consulta, se necessário
}
