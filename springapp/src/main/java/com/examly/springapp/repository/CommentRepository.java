package com.examly.springapp.repository;

import com.examly.springapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // For getting comments of a task
    List<Comment> findByTaskId(Long taskId);
}
