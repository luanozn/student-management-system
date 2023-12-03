package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Student;
import com.example.studentmanagementsystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Método para listar todos os estudantes
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Método para obter um estudante por ID
    public Optional<Student> getStudentById(UUID studentId) {
        return studentRepository.findById(studentId);
    }

    // Método para adicionar um novo estudante
    public Student addStudent(Student student) {
        // Implemente a lógica necessária antes de salvar, se aplicável
        return studentRepository.save(student);
    }

    // Método para atualizar um estudante existente
    public Optional<Student> updateStudent(UUID studentId, Student updatedStudent) {
        // Verifica se o estudante existe
        if (studentRepository.existsById(studentId)) {
            // Implemente a lógica necessária antes de salvar, se aplicável
            updatedStudent.setId(studentId); // Garante que o ID seja preservado
            return Optional.of(studentRepository.save(updatedStudent));
        } else {
            return Optional.empty(); // Retorna um Optional vazio se o estudante não for encontrado
        }
    }

    // Método para deletar um estudante por ID
    public boolean deleteStudent(UUID studentId) {
        // Verifica se o estudante existe antes de tentar deletar
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return true;
        } else {
            return false; // Retorna false se o estudante não for encontrado
        }
    }
}

