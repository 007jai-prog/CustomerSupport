package com.examly.springapp.repository;

import com.examly.springapp.model.TaskStatusLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog, Long> {

    // For /api/status-logs/task/{taskId}
    List<TaskStatusLog> findByTaskId(Long taskId);

    // For /api/status-logs/old/{oldStatus}
    List<TaskStatusLog> findByOldStatus(String oldStatus);
}
