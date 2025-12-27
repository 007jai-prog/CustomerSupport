package com.examly.springapp.service;

import com.examly.springapp.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Task updateTaskStatus(Long id, String status);

    List<Task> getTasksByUserId(Long userId);

    List<Task> getTasksByStatus(String status);
}
