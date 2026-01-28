package com.revconnect.controller;

import com.revconnect.model.Post;
import com.revconnect.service.IPostService;
import com.revconnect.service.PostServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class PostController {

    private IPostService postService;

    public PostController() {
        this.postService = new PostServiceImpl();
    }

    // Simulating a POST request handler
    public void createPost(int postId, int userId, String content, String postType, String[] hashtags) {
        Post post = new Post();
        post.setPostId(postId);
        post.setUserId(userId);
        post.setContent(content);
        post.setPostType(postType);
        post.setCreatedAt(LocalDateTime.now());

        int createdPostId = postService.createPostWithHashtags(post, List.of(hashtags));
        if (createdPostId != -1) {
            System.out.println("Post created successfully with ID: " + createdPostId);
        } else {
            System.out.println("Failed to create post.");
        }
    }
}
