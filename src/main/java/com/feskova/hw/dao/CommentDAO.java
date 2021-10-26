package com.feskova.hw.dao;

import com.feskova.hw.models.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getAll(int postId);
    void save(Comment comment, int postId);
}
