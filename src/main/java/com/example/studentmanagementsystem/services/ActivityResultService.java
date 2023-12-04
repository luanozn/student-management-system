package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.ActivityResult;
import com.example.studentmanagementsystem.repositories.ActivityResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityResultService {

    @Autowired
    private ActivityResultRepository activityResultRepository;

    public List<ActivityResult> getAllActivityResults() {
        return activityResultRepository.findAll();
    }

    public ActivityResult addActivityResult(ActivityResult activityResult) {
        return activityResultRepository.save(activityResult);
    }

    public ActivityResult updateActivityResult(UUID id, ActivityResult updatedActivityResult) {
        ActivityResult existingActivityResult = activityResultRepository.findById(id).orElse(null);

        if (existingActivityResult != null) {
            existingActivityResult.setActivity(updatedActivityResult.getActivity());
            existingActivityResult.setStudent(updatedActivityResult.getStudent());
            existingActivityResult.setGrade(updatedActivityResult.getGrade());

            return activityResultRepository.save(existingActivityResult);
        }

        return null;
    }

}
