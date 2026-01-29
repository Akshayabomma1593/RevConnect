package com.revconnect.model;

import java.time.LocalDateTime;

public class Post {

    private int postId;
    private int userId;
    private String content;
    private String postType;
    private Integer originalPostId;
    private boolean isPinned;
    private LocalDateTime createdAt;

    public Post() {}

    public Post(int postId, int userId, String content, String postType,
                Integer originalPostId, boolean isPinned,
                LocalDateTime createdAt) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.postType = postType;
        this.originalPostId = originalPostId;
        this.isPinned = isPinned;
        this.createdAt = createdAt;
    }

    // getters & setters
    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getPostType() { return postType; }
    public void setPostType(String postType) { this.postType = postType; }

    public Integer getOriginalPostId() { return originalPostId; }
    public void setOriginalPostId(Integer originalPostId) {
        this.originalPostId = originalPostId;
    }

    public boolean isPinned() { return isPinned; }
    public void setPinned(boolean isPinned) { this.isPinned = isPinned; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
