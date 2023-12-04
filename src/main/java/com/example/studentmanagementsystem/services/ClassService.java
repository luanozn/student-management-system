package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Class;
import com.example.studentmanagementsystem.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Método para listar todas as turmas
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    // Método para obter uma turma por ID
    public Optional<Class> getClassById(Long classId) {
        return classRepository.findById(classId);
    }

    // Método para adicionar uma nova turma
    public Class addClass(Class classEntity) {
        // Implemente a lógica necessária antes de salvar, se aplicável
        return classRepository.save(classEntity);
    }

    // Método para editar uma turma existente
    public Optional<Class> updateClass(Long classId, Class updatedClass) {
        // Verifica se a turma existe
        if (classRepository.existsById(classId)) {
            // Implemente a lógica necessária antes de salvar, se aplicável
            updatedClass.setId(classId); // Garante que o ID seja preservado
            return Optional.of(classRepository.save(updatedClass));
        } else {
            return Optional.empty(); // Retorna um Optional vazio se a turma não for encontrada
        }
    }

    // Método para deletar uma turma por ID
    public boolean deleteClass(Long classId) {
        // Verifica se a turma existe antes de tentar deletar
        if (classRepository.existsById(classId)) {
            classRepository.deleteById(classId);
            return true;
        } else {
            return false; // Retorna false se a turma não for encontrada
        }
    }
}
