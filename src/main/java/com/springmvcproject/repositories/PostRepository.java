package com.springmvcproject.repositories;

import com.springmvcproject.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();

    public PostRepository() {
        Post post = new Post();
        post.setTitle("Post 1");
        post.setDescription("This is a post 1");
        post.setBody("This is a post's 1 body ");

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setDescription("This is a post 2");
        post2.setBody("This is a post's 2 body ");

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setDescription("This is a post 3");
        post3.setBody("This is a post's 3 body ");

        posts.add(post);
        posts.add(post2);
        posts.add(post3);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

}
