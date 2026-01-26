package com.revconnect.controller;

import com.revconnect.service.InteractionServiceImpl;

public class InteractionController {

    public static void main(String[] args) {

        InteractionServiceImpl service = new InteractionServiceImpl();

        // MUST match existing DB rows
        long userId = 2;     //exists in USERS
        long postId = 102;   // exists in POSTS

        service.likePost(userId, postId);
        service.commentPost(userId, postId, "Nice post!");
        service.sharePost(userId, postId);
        service.viewPostAnalytics(postId);
    }
}
