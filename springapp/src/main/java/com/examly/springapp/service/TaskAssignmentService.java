package com.examly.springapp.service;

import com.examly.springapp.model.TaskAssignment;

import java.util.List;

public interface TaskAssignmentService {

    TaskAssignment createAssignment(TaskAssignment assignment);

    List<TaskAssignment> getAssignmentsByUserId(Long userId);
}
