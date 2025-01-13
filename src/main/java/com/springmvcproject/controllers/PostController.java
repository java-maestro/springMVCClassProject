package com.springmvcproject.controllers;

import com.springmvcproject.models.Post;
import com.springmvcproject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    public PostService postService;

    @GetMapping("/posts")
    public String posts (Model model ){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model){
     model.addAttribute("newPost", new Post());
     return "createPost";
    }


    @PostMapping("/posts")
    public String create(@ModelAttribute("newPost") Post post){
          postService.createPost(post);
          return "redirect:/posts";
    }

}
