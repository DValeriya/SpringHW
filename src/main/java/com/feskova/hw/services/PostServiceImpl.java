package com.feskova.hw.services;

import com.feskova.hw.dao.PostDAO;
import com.feskova.hw.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostDAO postDAO;
    private CommentService commentService;

    @Autowired
    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void save(Post post) {
        postDAO.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postDAO.getAll();
    }

    @Override
    public Post getById(int id) {
        Post post = postDAO.getById(id);
        post.setComments(commentService.getAll(post.getId()));
        return post;
    }
}
