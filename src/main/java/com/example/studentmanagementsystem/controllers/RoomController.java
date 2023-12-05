package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Room;
import com.example.studentmanagementsystem.services.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@Tag(name = "rooms")
public class RoomController {


    @Autowired
    private RoomService roomService;

    @Operation(summary = "Endpoint to get all rooms", method = "GET")
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}

