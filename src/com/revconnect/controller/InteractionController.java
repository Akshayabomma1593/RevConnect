package com.revconnect.controller;

import com.revconnect.service.interaction.InteractionService;
import com.revconnect.service.interaction.InteractionServiceImpl;
import com.revconnect.service.interaction.InteractionService;
import com.revconnect.service.interaction.InteractionServiceImpl;

public class InteractionController {

    private final InteractionService service = new InteractionServiceImpl();

    public static void main(String[] args) {


        InteractionController controller = new InteractionController();

        controller.likePost(1L, 10L);
        controller.commentPost(1L, 10L, "Nice post!");
    }

    public void likePost(Long userId, Long postId) {
        service.likePost(userId, postId);
        System.out.println("Post liked successfully");
    }

    public void commentPost(Long userId, Long postId, String comment) {
        service.commentPost(userId, postId, comment);
        System.out.println("Comment added successfully");
    }
}
