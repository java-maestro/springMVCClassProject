package com.springmvcproject.repositories;

import com.springmvcproject.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {
    public  int commentRootId=1;
    public List<Comment> commentList =new ArrayList<>();


    public List<Comment> getCommentList(int postId){
        return commentList.stream().filter(comment -> comment.getPostId() == postId).toList();
    }

    public void addComment(Comment comment){
        commentList.add(comment);
    }




}
