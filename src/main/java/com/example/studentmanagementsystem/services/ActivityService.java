package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entities.Activity;
import com.example.studentmanagementsystem.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(UUID id, Activity updatedActivity) {
        Activity existingActivity = activityRepository.findById(id).orElse(null);

        if (existingActivity != null) {
            // Update properties of existingActivity with properties of updatedActivity
            existingActivity.setClassEntity(updatedActivity.getClassEntity());
            existingActivity.setDate(updatedActivity.getDate());

            return activityRepository.save(existingActivity);
        }

        return null;
    }

    public boolean deleteActivity(UUID id) {
        if (activityRepository.existsById(id)) {
            activityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
