package com.revconnect.service;

import com.revconnect.dao.InteractionDaoImpl;

public class InteractionServiceImpl {

    private final InteractionDaoImpl dao = new InteractionDaoImpl();

    public void likePost(long userId, long postId) {
        dao.saveInteraction(userId, postId, "LIKE", null);
        System.out.println("✅ Post liked successfully");
    }

    public void commentPost(long userId, long postId, String comment) {
        dao.saveInteraction(userId, postId, "COMMENT", comment);
        System.out.println("✅ Comment added successfully");
    }

    public void sharePost(long userId, long postId) {
        dao.saveInteraction(userId, postId, "SHARE", null);
        System.out.println("✅ Post shared successfully");
    }

    public void viewPostAnalytics(long postId) {
        int likes = dao.countByType(postId, "LIKE");
        int comments = dao.countByType(postId, "COMMENT");
        int shares = dao.countByType(postId, "SHARE");

        System.out.println("\n📊 Post Analytics:");
        System.out.println("Likes   : " + likes);
        System.out.println("Comments: " + comments);
        System.out.println("Shares  : " + shares);
        System.out.println("Reach   : " + (likes + comments + shares));
    }
}
