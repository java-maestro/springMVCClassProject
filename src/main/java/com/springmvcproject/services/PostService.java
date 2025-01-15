package com.springmvcproject.services;

import com.springmvcproject.models.Comment;
import com.springmvcproject.models.Post;
import com.springmvcproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.getPosts();
        List<Post> postsWithComments = new ArrayList<>();

        for(int i =0; i < posts.size(); i++){
            Post post = posts.get(i);
            List<Comment> comments = commentService.getAllCommentsByPostId(post.getPostId());
            post.setComments(comments);

            postsWithComments.add(post);
        }

        return  postsWithComments;
    }

    public void createPost(Post post) {
        postRepository.addPost(post);
    }

    public Optional<Post> getPostById(int id) {

       return Optional.ofNullable(postRepository.findById(id));
    }

    public void updatePost(Post updatedPost) {
        postRepository.updatePost(updatedPost);
    }

    public void deletePostByID(int id) {
        postRepository.deletePost(id);
    }

}
