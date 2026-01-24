package com.revconnect.dao.analytics;

public interface PostAnalyticsDao {

    long getLikeCount(Long postId);

    long getCommentCount(Long postId);
}
