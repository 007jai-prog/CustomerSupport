package com.examly.springapp.repository;

import com.examly.springapp.model.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {

    // For /api/assignments/user/{userId}
    List<TaskAssignment> findByUserId(Long userId);
}
