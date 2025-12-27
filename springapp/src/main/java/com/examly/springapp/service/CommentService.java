package com.examly.springapp.service;

import com.examly.springapp.model.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment);

    List<Comment> getCommentsByTaskId(Long taskId);
}
