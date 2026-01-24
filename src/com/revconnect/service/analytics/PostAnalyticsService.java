package com.revconnect.service.analytics;

public interface PostAnalyticsService {

    long getLikes(Long postId);

    long getComments(Long postId);
}
