package com.springmvcproject.services;

import com.springmvcproject.models.Comment;
import com.springmvcproject.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    private CommentRepository commentRepository;


    public List<Comment> getAllCommentsByPostId(int postId) {
        return  commentRepository.getCommentList(postId);
    }

    public void createComment(Comment comment) {
        commentRepository.addComment(comment);
    }

}
