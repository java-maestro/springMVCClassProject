package com.springmvcproject.repositories;

import com.springmvcproject.enums.PostStatus;
import com.springmvcproject.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private int postrootId = 1;
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

        this.addPost(post);
        this.addPost(post2);
        this.addPost(post3);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        post.setPostId(postrootId);
        post.setPostStatus(PostStatus.PUBLISHED);
        this.posts.add(post);
        postrootId++;
    }

    public Post findById(int id) {
        for(Post post : posts) {
            if(post.getPostId() == id) {
                return post;
            }
        }
        return null;
    }

    public void updatePost(Post updatedPost) {
     for(int i = 0; i < posts.size(); i++) {
         if(posts.get(i).getPostId() == updatedPost.getPostId()) {
             posts.set(i, updatedPost);
             break;
         }
     }
    }


    public void deletePost(int id) {
        for(int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getPostId() == id) {
                posts.remove(i);
                break;
            }
        }
    }


}
