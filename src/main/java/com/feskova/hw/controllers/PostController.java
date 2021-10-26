package com.feskova.hw.controllers;

import com.feskova.hw.models.Post;
import com.feskova.hw.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping(value = "/add_post",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addPost(Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/add_post")
    public String getPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "add_post";
    }

    @GetMapping("/{post_id}")
    public String show(@PathVariable("post_id") int post_id, Model model) {
        model.addAttribute("post", postService.getById(post_id));
        return "post";
    }
}
