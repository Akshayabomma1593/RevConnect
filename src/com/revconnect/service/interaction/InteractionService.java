package com.revconnect.service.interaction;

public interface InteractionService {

    void likePost(Long userId, Long postId);

    void commentPost(Long userId, Long postId, String comment);
}
