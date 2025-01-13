package com.springmvcproject.models;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class Comment {
    private int id;
    private String title;
    private String authorName;
    private Integer postId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
