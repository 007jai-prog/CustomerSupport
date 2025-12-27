package com.examly.springapp.service;

import com.examly.springapp.model.TaskStatusLog;
import com.examly.springapp.repository.TaskStatusLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusLogServiceImpl implements TaskStatusLogService {

    @Autowired
    private TaskStatusLogRepository taskStatusLogRepository;

    @Override
    public TaskStatusLog createStatusLog(TaskStatusLog log) {
        return taskStatusLogRepository.save(log);
    }

    @Override
    public List<TaskStatusLog> getAllLogs() {
        return taskStatusLogRepository.findAll();
    }

    @Override
    public Optional<TaskStatusLog> getLogById(Long id) {
        return taskStatusLogRepository.findById(id);
    }

    @Override
    public List<TaskStatusLog> getLogsByTaskId(Long taskId) {
        return taskStatusLogRepository.findByTaskId(taskId);
    }

    @Override
    public List<TaskStatusLog> getLogsByOldStatus(String oldStatus) {
        return taskStatusLogRepository.findByOldStatus(oldStatus);
    }
}
