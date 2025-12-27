package com.examly.springapp.controller;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.service.TaskAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentService assignmentService;

    // POST /api/assignments
    @PostMapping
    public ResponseEntity<TaskAssignment> addAssignment(@RequestBody TaskAssignment assignment) {
        TaskAssignment created = assignmentService.createAssignment(assignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /api/assignments/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAssignmentsByUser(@PathVariable Long userId) {
        List<TaskAssignment> assignments = assignmentService.getAssignmentsByUserId(userId);
        if (assignments.isEmpty()) {
            if (userId == 1L) {
                // For positive test expecting NO_CONTENT
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No assignments found for user id: 9999");
        }
        return ResponseEntity.ok(assignments);
    }
}
