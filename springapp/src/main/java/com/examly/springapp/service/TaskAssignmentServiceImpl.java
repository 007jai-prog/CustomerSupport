package com.examly.springapp.service;

import com.examly.springapp.model.TaskAssignment;
import com.examly.springapp.repository.TaskAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    @Autowired
    private TaskAssignmentRepository taskAssignmentRepository;

    @Override
    public TaskAssignment createAssignment(TaskAssignment assignment) {
        return taskAssignmentRepository.save(assignment);
    }

    @Override
    public List<TaskAssignment> getAssignmentsByUserId(Long userId) {
        return taskAssignmentRepository.findByUserId(userId);
    }
}
