package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.Activity;
import com.example.studentmanagementsystem.services.ActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/activities")
@Tag(name = "activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Operation(summary = "Search for all activities in the database", method = "GET")
    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return ResponseEntity.ok(activities);
    }

    @Operation(summary = "Insert an activity in the database", method = "POST")
    @PostMapping
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity newActivity = activityService.addActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newActivity);
    }

    @Operation(summary = "Update an activity in the database", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable UUID id, @RequestBody Activity activity) {
        Activity updatedActivity = activityService.updateActivity(id, activity);
        return updatedActivity != null
                ? ResponseEntity.ok(updatedActivity)
                : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete an activity from the database", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable UUID id) {
        boolean deleted = activityService.deleteActivity(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
