package com.feskova.hw.services;

import com.feskova.hw.models.Post;

import java.util.List;

public interface PostService {
    void save(Post post);
    List<Post> getAll();
    Post getById(int id);
}
