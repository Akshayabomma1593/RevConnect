package com.revconnect.service;

import com.revconnect.model.PostAnalytics;

public interface InteractionService {

    void likePost(int userId, int postId);

    void commentPost(int userId, int postId, String comment);

    void sharePost(int userId, int postId);

    PostAnalytics viewPostAnalytics(int postId);
}
