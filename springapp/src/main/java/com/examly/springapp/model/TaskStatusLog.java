package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "task_status_logs")
public class TaskStatusLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String oldStatus;

    @Column(nullable = false)
    private String newStatus;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    
    @ManyToOne
    @JoinColumn(name = "changed_by_user_id")
    private User changedByUser;
    
    

    private LocalDateTime changedAt;

    public TaskStatusLog() {
    }

    public TaskStatusLog(Long id) {
        this.id = id;
    }

    public TaskStatusLog(Long id, String oldStatus, String newStatus,
                         Task task, User changedByUser, LocalDateTime changedAt) {
        this.id = id;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.task = task;
        this.changedByUser = changedByUser;
        this.changedAt = changedAt;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getChangedByUser() {
        return changedByUser;
    }

    public void setChangedByUser(User changedByUser) {
        this.changedByUser = changedByUser;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}
