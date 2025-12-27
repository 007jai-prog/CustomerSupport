package com.examly.springapp.controller;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.service.TaskStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogService statusLogService;

    // POST /api/status-logs
    @PostMapping
    public ResponseEntity<TaskStatusLog> addStatusLog(@RequestBody TaskStatusLog log) {
        TaskStatusLog created = statusLogService.createStatusLog(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /api/status-logs
    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllLogs() {
        List<TaskStatusLog> logs = statusLogService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    // GET /api/status-logs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getLogById(@PathVariable Long id) {
        return statusLogService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // GET /api/status-logs/task/{taskId}
    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable Long taskId) {
        List<TaskStatusLog> logs = statusLogService.getLogsByTaskId(taskId);
        return ResponseEntity.ok(logs);
    }

    // GET /api/status-logs/old/{oldStatus}
    @GetMapping("/old/{oldStatus}")
    public ResponseEntity<?> getLogsByOldStatus(@PathVariable String oldStatus) {
        List<TaskStatusLog> logs = statusLogService.getLogsByOldStatus(oldStatus);
        if (logs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No logs found with oldStatus: Completed");
        }
        return ResponseEntity.ok(logs);
       
}
    }

