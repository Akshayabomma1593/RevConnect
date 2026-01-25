package com.revconnect.model;

import java.time.LocalDateTime;

public class Interaction {
    private int interactionId;
    private int postId;
    private int userId;
    private String interactionType;
    private String commentText;
    private LocalDateTime createdAt;

    public Interaction() {}

    public Interaction(int interactionId, int postId, int userId,
                       String interactionType, String commentText,
                       LocalDateTime createdAt) {
        this.interactionId = interactionId;
        this.postId = postId;
        this.userId = userId;
        this.interactionType = interactionType;
        this.commentText = commentText;
        this.createdAt = createdAt;
    }

    // getters & setters
    public int getInteractionId() { return interactionId; }
    public void setInteractionId(int interactionId) { this.interactionId = interactionId; }

    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getInteractionType() { return interactionType; }
    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }

    public String getCommentText() { return commentText; }
    public void setCommentText(String commentText) { this.commentText = commentText; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}