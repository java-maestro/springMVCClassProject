package com.springmvcproject.controllers;

import com.springmvcproject.models.Post;
import com.springmvcproject.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @PostMapping("/posts/create")
    public String create(@ModelAttribute("newPost") @Valid Post post, Errors errors){

        if(errors.hasErrors()){
            return "createPost"; // html page name
        }

          postService.createPost(post);
          return "redirect:/posts";  // url end point.
    }
    
    @GetMapping("/update/{id}")
    public String updatePost(@PathVariable("id") int id, Model model){
         Post updatePost = null;

         Optional<Post> optionalPost = postService.getPostById(id);

        if(optionalPost.isPresent()){
            updatePost = optionalPost.get();
        }else{
            return "redirect:/posts";
        }

        model.addAttribute("postToBeUpdated", updatePost);

        return "updatePostPage";  // html page name
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("postToBeUpdated") @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return "updatePostPage";  // html page name
        }
        post.setPostId(id);
        postService.updatePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model){

        Optional<Post> optionalPost = postService.getPostById(id);
        if(optionalPost.isPresent()){
            model.addAttribute("postToBeDeleted", optionalPost.get());
        }else{
            return "redirect:/posts";
        }
        return "deletePostPage";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        postService.deletePostByID(id);
        return "redirect:/posts";
    }



}
