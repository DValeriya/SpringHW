package com.feskova.hw.dao;

import com.feskova.hw.models.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAll();
    Post getById(int id);
    void save(Post post);
}
