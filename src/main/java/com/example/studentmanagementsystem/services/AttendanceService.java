package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Attendance;
import com.example.studentmanagementsystem.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance getAttendanceById(UUID id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance updateAttendance(UUID id, Attendance updatedAttendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);

        if (existingAttendance != null) {
            existingAttendance.setStudent(updatedAttendance.getStudent());
            existingAttendance.setClassEntity(updatedAttendance.getClassEntity());
            existingAttendance.setDate(updatedAttendance.getDate());
            existingAttendance.setAttendance(updatedAttendance.isAttendance());

            return attendanceRepository.save(existingAttendance);
        }

        return null;
    }

    public boolean deleteAttendance(UUID id) {
        if (attendanceRepository.existsById(id)) {
            attendanceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
