package com.revconnect.service;

import com.revconnect.dao.InteractionDao;
import com.revconnect.dao.InteractionDaoImpl;
import com.revconnect.model.Interaction;
import com.revconnect.model.PostAnalytics;

import java.time.LocalDateTime;

public class InteractionServiceImpl implements InteractionService {

    private final InteractionDao interactionDao = new InteractionDaoImpl();

    @Override
    public void likePost(int userId, int postId) {
        Interaction i = new Interaction();
        i.setUserId(userId);
        i.setPostId(postId);
        i.setInteractionType("LIKE");
        i.setCreatedAt(LocalDateTime.now());
        interactionDao.saveInteraction(i);
    }

    @Override
    public void commentPost(int userId, int postId, String comment) {
        Interaction i = new Interaction();
        i.setUserId(userId);
        i.setPostId(postId);
        i.setInteractionType("COMMENT");
        i.setCommentText(comment);
        i.setCreatedAt(LocalDateTime.now());
        interactionDao.saveInteraction(i);
    }

    @Override
    public void sharePost(int userId, int postId) {
        Interaction i = new Interaction();
        i.setUserId(userId);
        i.setPostId(postId);
        i.setInteractionType("SHARE");
        i.setCreatedAt(LocalDateTime.now());
        interactionDao.saveInteraction(i);
    }

    @Override
    public PostAnalytics viewPostAnalytics(int postId) {
        return interactionDao.getPostAnalytics(postId);
    }
}
