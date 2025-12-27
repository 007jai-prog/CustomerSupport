package com.examly.springapp.repository;

import com.examly.springapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // For /api/tasks/user/{userId}
    List<Task> findByCreatedById(Long userId);

    // For /api/tasks/status/{status}
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findByStatus(String status);
}
