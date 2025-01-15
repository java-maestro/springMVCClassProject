package com.springmvcproject.controllers;

import com.springmvcproject.models.Comment;
import com.springmvcproject.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;


    @GetMapping("posts/{postId}/comment/create")
    public String createComment(@PathVariable int postId, Model model) {

        model.addAttribute("newComment", new Comment());

        return "createCommentPage";

    }


    @PostMapping("posts/{postId}/comment/create")
    public String create(@PathVariable int postId, @ModelAttribute("newComment") Comment newComment, Errors errors) {
        if(errors.hasErrors()) {
            return "createCommentPage";
        }
        newComment.setPostId(postId);
        commentService.createComment(newComment);

        return "redirect:/posts";
    }
}
