package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Professor;
import com.example.studentmanagementsystem.services.ProfessorService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Endpoint para listar todos os professores
    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professors = professorService.getAllProfessors();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable UUID professorId) {
        Optional<Professor> professor = professorService.getProfessorById(professorId);
        return professor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para adicionar um novo professor
    @PostMapping
    public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor) {
        Professor newProfessor = professorService.addProfessor(professor);
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

    // Endpoint para editar um professor existente
    @PutMapping("/{professorId}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable UUID professorId, @RequestBody Professor professor) {
        Optional<Professor> updatedProfessor = professorService.updateProfessor(professorId, professor);
        return updatedProfessor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para deletar um professor por ID
    @DeleteMapping("/{professorId}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable UUID professorId) {
        if (professorService.deleteProfessor(professorId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
