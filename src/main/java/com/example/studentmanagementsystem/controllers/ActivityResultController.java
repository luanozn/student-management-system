package com.example.studentmanagementsystem.controllers;

import com.example.studentmanagementsystem.entities.ActivityResult;
import com.example.studentmanagementsystem.services.ActivityResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/activity-results")
@Tag(name = "activity-result")
public class ActivityResultController {

   @Autowired
   private ActivityResultService activityResultService;

    @Operation(summary = "Search for all activity results in the database", method = "GET")
    @GetMapping
    public ResponseEntity<List<ActivityResult>> getAllActivityResults() {
        List<ActivityResult> activityResults = activityResultService.getAllActivityResults();
        return ResponseEntity.ok(activityResults);
    }

    @Operation(summary = "Insert an activity result in the database", method = "POST")
    @PostMapping
    public ResponseEntity<ActivityResult> addActivityResult(@RequestBody ActivityResult activityResult) {
        ActivityResult newActivityResult = activityResultService.addActivityResult(activityResult);
        return ResponseEntity.status(HttpStatus.CREATED).body(newActivityResult);
    }

    @Operation(summary = "Update an activity result in the database", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<ActivityResult> updateActivityResult(
            @PathVariable UUID id, @RequestBody ActivityResult activityResult) {
        ActivityResult updatedActivityResult = activityResultService.updateActivityResult(id, activityResult);
        return updatedActivityResult != null
                ? ResponseEntity.ok(updatedActivityResult)
                : ResponseEntity.notFound().build();
    }
}
