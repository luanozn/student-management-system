package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Administrator;
import com.example.studentmanagementsystem.services.AdministratorService;
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
@RequestMapping("/api/administrators")
@Tag(name="administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Operation(summary = "Endpoint para listar todos os administradores", method = "GET")
    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> administrators = administratorService.getAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }

    @Operation(summary = "Endpoint para obter um administrador por ID", method = "GET")
    @GetMapping("/{administratorId}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable UUID administratorId) {
        Optional<Administrator> administrator = administratorService.getAdministratorById(administratorId);
        return administrator.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Endpoint para adicionar um novo administrador", method = "POST")
    @PostMapping
    public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator administrator) {
        Administrator newAdministrator = administratorService.addAdministrator(administrator);
        return new ResponseEntity<>(newAdministrator, HttpStatus.CREATED);
    }

    @Operation(summary = "Endpoint para editar um administrador", method = "PUT")

    @PutMapping("/{administratorId}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable UUID administratorId, @RequestBody Administrator administrator) {
        Optional<Administrator> updatedAdministrator = administratorService.updateAdministrator(administratorId, administrator);
        return updatedAdministrator.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Endpoint para deletar um administrador", method = "DELETE")
    @DeleteMapping("/{administratorId}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable UUID administratorId) {
        if (administratorService.deleteAdministrator(administratorId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
