package com.springmvcproject.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int  postId;
    private String title;
    private String description;
    private String body;
    private String postStatus ;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;

    public Post(){

    }

    public Post(int postId, String title, String description, String body, String postStatus, LocalDateTime createdOn, LocalDateTime updatedOn, List<Comment> comments) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.body = body;
        this.postStatus = postStatus;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.comments = comments;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", postStatus='" + postStatus + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", comments=" + comments +
                '}';
    }
}
