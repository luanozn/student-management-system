package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Subject;
import com.example.studentmanagementsystem.services.SubjectService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable UUID id) {
        Subject subject = subjectService.getSubjectById(id);
        return subject != null
                ? ResponseEntity.ok(subject)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        Subject newSubject = subjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSubject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable UUID id, @RequestBody Subject subject) {
        Subject updatedSubject = subjectService.updateSubject(id, subject);
        return updatedSubject != null
                ? ResponseEntity.ok(updatedSubject)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable UUID id) {
        boolean deleted = subjectService.deleteSubject(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<String>> getStudentsBySubject(@PathVariable UUID id) {
        Map<UUID, List<String>> studentsBySubject = subjectService.getStudentsBySubject();
        var students = studentsBySubject.get(id);
        return ResponseEntity.ok(students);
    }
}
