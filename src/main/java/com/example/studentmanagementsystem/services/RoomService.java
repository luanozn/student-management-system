package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Room;
import com.example.studentmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
