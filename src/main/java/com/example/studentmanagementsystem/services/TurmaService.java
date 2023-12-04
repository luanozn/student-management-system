package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.repositories.TurmaRepository;
import com.example.studentmanagementsystem.entities.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    // Método para listar todas as turmas
    public List<Turma> getAllClasses() {
        return turmaRepository.findAll();
    }

    // Método para obter uma turma por ID
    public Optional<Turma> getClassById(Long classId) {
        return turmaRepository.findById(classId);
    }

    // Método para adicionar uma nova turma
    public Turma addClass(Turma classEntity) {
        return turmaRepository.save(classEntity);
    }

    // Método para editar uma turma existente
    public Optional<Turma> updateClass(Long classId, Turma updatedClass) {
        if (turmaRepository.existsById(classId)) {
            updatedClass.setId(classId); // Garante que o ID seja preservado
            return Optional.of(turmaRepository.save(updatedClass));
        } else {
            return Optional.empty(); // Retorna um Optional vazio se a turma não for encontrada
        }
    }

    // Método para deletar uma turma por ID
    public boolean deleteClass(Long classId) {
        // Verifica se a turma existe antes de tentar deletar
        if (turmaRepository.existsById(classId)) {
            turmaRepository.deleteById(classId);
            return true;
        } else {
            return false; // Retorna false se a turma não for encontrada
        }
    }
}
