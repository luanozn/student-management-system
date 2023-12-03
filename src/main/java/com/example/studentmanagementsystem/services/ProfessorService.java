package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Professor;
import com.example.studentmanagementsystem.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Método para listar todos os professores
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // Método para obter um professor por ID
    public Optional<Professor> getProfessorById(UUID professorId) {
        return professorRepository.findById(professorId);
    }

    // Método para adicionar um novo professor
    public Professor addProfessor(Professor professor) {
        // Implemente a lógica necessária antes de salvar, se aplicável
        return professorRepository.save(professor);
    }

    // Método para atualizar um professor existente
    public Optional<Professor> updateProfessor(UUID professorId, Professor updatedProfessor) {
        if (professorRepository.existsById(professorId)) {

            updatedProfessor.setId(professorId); // Garante que o ID seja preservado
            return Optional.of(professorRepository.save(updatedProfessor));
        } else {
            return Optional.empty(); // Retorna um Optional vazio se o professor não for encontrado
        }
    }

    public boolean deleteProfessor(UUID professorId) {
        // Verifica se o professor existe antes de tentar deletar
        if (professorRepository.existsById(professorId)) {
            professorRepository.deleteById(professorId);
            return true;
        } else {
            return false; // Retorna false se o professor não for encontrado
        }
    }
}
