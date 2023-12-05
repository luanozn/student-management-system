package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Attendance;
import com.example.studentmanagementsystem.services.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attendances")
@Tag(name = "attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Operation(summary = "Endpoint to get all attendances", method = "GET")
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return ResponseEntity.ok(attendances);
    }

    @Operation(summary = "Endpoint to insert an attendance", method = "POST")
    @PostMapping
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance newAttendance = attendanceService.addAttendance(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAttendance);
    }

    @Operation(summary = "Endpoint to get an attendance by id", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable UUID id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        return attendance != null
                ? ResponseEntity.ok(attendance)
                : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Endpoint to Update an attendance", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable UUID id, @RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(id, attendance);
        return updatedAttendance != null
                ? ResponseEntity.ok(updatedAttendance)
                : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Endpoint to delete an attendance", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable UUID id) {
        boolean deleted = attendanceService.deleteAttendance(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}