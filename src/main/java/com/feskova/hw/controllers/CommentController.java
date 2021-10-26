package com.feskova.hw.controllers;

import com.feskova.hw.models.Comment;
import com.feskova.hw.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{post_id}/add_comment")
    public String getCommentForm(Model model, @PathVariable("post_id") int post_id) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("post_id", post_id);
        return "add_comment";
    }

    @PostMapping(value = "/{post_id}/add_comment",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addComment(Comment comment, @PathVariable("post_id") int post_id) {
        commentService.save(comment, post_id);
        return "redirect:/" + post_id;
    }
}
