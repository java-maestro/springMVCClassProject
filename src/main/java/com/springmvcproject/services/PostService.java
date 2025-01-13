package com.springmvcproject.services;

import com.springmvcproject.models.Post;
import com.springmvcproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return  postRepository.getPosts();
    }

    public void createPost(Post post) {
        postRepository.addPost(post);
    }
}
