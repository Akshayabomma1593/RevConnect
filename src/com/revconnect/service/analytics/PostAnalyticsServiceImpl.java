package com.revconnect.service.analytics;

import com.revconnect.dao.analytics.PostAnalyticsDao;
import com.revconnect.dao.analytics.PostAnalyticsDaoImpl;

public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    private final PostAnalyticsDao dao = new PostAnalyticsDaoImpl();

    @Override
    public long getLikes(Long postId) {
        return dao.getLikeCount(postId);
    }

    @Override
    public long getComments(Long postId) {
        return dao.getCommentCount(postId);
    }
}
