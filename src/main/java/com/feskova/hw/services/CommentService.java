package com.feskova.hw.services;

import com.feskova.hw.models.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAll(int postId);
    void save(Comment comment, int postId);
}
