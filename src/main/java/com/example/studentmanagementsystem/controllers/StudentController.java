package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Student;
import com.example.studentmanagementsystem.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/student")
@Tag(name = "student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Endpoint para listar todos os estudantes
    @Operation(summary = "Endpoint to get all students", method = "GET")
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Endpoint para obter um estudante por ID
    @Operation(summary = "Endpoint to get a student by id", method = "GET")
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para adicionar um novo estudante
    @Operation(summary = "Endpoint to add a new Student", method = "POST")
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @Operation(summary = "Endpoint to update a student", method = "PUT")
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable UUID studentId, @RequestBody Student student) {
        Optional<Student> updatedStudent = studentService.updateStudent(studentId, student);
        return updatedStudent.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Endpoint to delete a student", method = "DELETE")
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID studentId) {
        if (studentService.deleteStudent(studentId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
