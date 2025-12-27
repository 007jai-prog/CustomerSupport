package com.examly.springapp.service;

import com.examly.springapp.model.TaskStatusLog;

import java.util.List;
import java.util.Optional;

public interface TaskStatusLogService {

    TaskStatusLog createStatusLog(TaskStatusLog log);

    List<TaskStatusLog> getAllLogs();

    Optional<TaskStatusLog> getLogById(Long id);

    List<TaskStatusLog> getLogsByTaskId(Long taskId);

    List<TaskStatusLog> getLogsByOldStatus(String oldStatus);
}
