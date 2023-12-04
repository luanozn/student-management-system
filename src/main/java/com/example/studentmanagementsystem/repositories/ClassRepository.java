package com.example.studentmanagementsystem.repositories;

import com.example.studentmanagementsystem.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {


}
