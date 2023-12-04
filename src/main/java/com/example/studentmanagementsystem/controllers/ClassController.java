package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Class;
import com.example.studentmanagementsystem.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Endpoint para listar todas as turmas
    @GetMapping
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    // Endpoint para obter uma turma por ID
    @GetMapping("/{classId}")
    public ResponseEntity<Class> getClassById(@PathVariable Long classId) {
        Optional<Class> classEntity = classService.getClassById(classId);
        return classEntity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para adicionar uma nova turma
    @PostMapping
    public ResponseEntity<Class> addClass(@RequestBody Class classEntity) {
        Class newClass = classService.addClass(classEntity);
        return new ResponseEntity<>(newClass, HttpStatus.CREATED);
    }

    // Endpoint para editar uma turma existente
    @PutMapping("/{classId}")
    public ResponseEntity<Class> updateClass(@PathVariable Long classId, @RequestBody Class classEntity) {
        Optional<Class> updatedClass = classService.updateClass(classId, classEntity);
        return updatedClass.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para deletar uma turma por ID
    @DeleteMapping("/{classId}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long classId) {
        if (classService.deleteClass(classId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
