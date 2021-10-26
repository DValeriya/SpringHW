package com.feskova.hw.services;

import com.feskova.hw.dao.CommentDAO;
import com.feskova.hw.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentDAO commentDAO;

    @Autowired
    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public List<Comment> getAll(int postId) {
        return commentDAO.getAll(postId);
    }

    @Override
    public void save(Comment comment, int postId) {
        commentDAO.save(comment, postId);
    }
}
