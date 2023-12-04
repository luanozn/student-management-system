package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Turma;
import com.example.studentmanagementsystem.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    // Endpoint para listar todas as turmas
    @GetMapping
    public ResponseEntity<List<Turma>> getAllClasses() {
        List<Turma> classes = turmaService.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    // Endpoint para obter uma turma por ID
    @GetMapping("/{classId}")
    public ResponseEntity<Turma> getClassById(@PathVariable Long classId) {
        Optional<Turma> classEntity = turmaService.getClassById(classId);
        return classEntity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para adicionar uma nova turma
    @PostMapping
    public ResponseEntity<Turma> addClass(@RequestBody Turma classEntity) {
        Turma newClass = turmaService.addClass(classEntity);
        return new ResponseEntity<>(newClass, HttpStatus.CREATED);
    }

    // Endpoint para editar uma turma existente
    @PutMapping("/{classId}")
    public ResponseEntity<Turma> updateClass(@PathVariable Long classId, @RequestBody Turma classEntity) {
        Optional<Turma> updatedClass = turmaService.updateClass(classId, classEntity);
        return updatedClass.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para deletar uma turma por ID
    @DeleteMapping("/{classId}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long classId) {
        if (turmaService.deleteClass(classId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
