package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Subject;
import com.example.studentmanagementsystem.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(UUID id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(UUID id, Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            existingSubject.setName(updatedSubject.getName());
            existingSubject.setDescription(updatedSubject.getDescription());
            return subjectRepository.save(existingSubject);
        }

        return null;
    }

    public boolean deleteSubject(UUID id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Map<Subject, List<String>> getStudentsBySubject() {
        // Obter todas as disciplinas
        List<Subject> subjects = getAllSubjects();

        // Mapear as disciplinas para a lista de alunos matriculados
        return subjects.stream()
                .collect(Collectors.toMap(
                        subject -> subject,
                        subject -> subject.getStudents().stream()
                                .map(student -> student.getName())
                                .collect(Collectors.toList())
                ));
    }
}
