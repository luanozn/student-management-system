package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Administrator;
import com.example.studentmanagementsystem.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    // Método para listar todos os administradores
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    // Método para obter um administrador por ID
    public Optional<Administrator> getAdministratorById(UUID administratorId) {
        return administratorRepository.findById(administratorId);
    }

    // Método para adicionar um novo administrador
    public Administrator addAdministrator(Administrator administrator) {
        // Implemente a lógica necessária antes de salvar, se aplicável
        return administratorRepository.save(administrator);
    }

    // Método para atualizar um administrador existente
    public Optional<Administrator> updateAdministrator(UUID administratorId, Administrator updatedAdministrator) {
        // Verifica se o administrador existe
        if (administratorRepository.existsById(administratorId)) {
            // Implemente a lógica necessária antes de salvar, se aplicável
            updatedAdministrator.setId(administratorId); // Garante que o ID seja preservado
            return Optional.of(administratorRepository.save(updatedAdministrator));
        } else {
            return Optional.empty(); // Retorna um Optional vazio se o administrador não for encontrado
        }
    }

    // Método para deletar um administrador por ID
    public boolean deleteAdministrator(UUID administratorId) {
        // Verifica se o administrador existe antes de tentar deletar
        if (administratorRepository.existsById(administratorId)) {
            administratorRepository.deleteById(administratorId);
            return true;
        } else {
            return false; // Retorna false se o administrador não for encontrado
        }
    }
}
