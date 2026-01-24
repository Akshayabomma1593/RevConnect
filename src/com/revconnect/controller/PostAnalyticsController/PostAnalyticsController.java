package com.revconnect.controller.PostAnalyticsController;

import com.revconnect.service.analytics.PostAnalyticsService;
import com.revconnect.service.analytics.PostAnalyticsServiceImpl;

public class PostAnalyticsController {

    public static void main(String[] args) {

        PostAnalyticsService service = new PostAnalyticsServiceImpl();

        Long postId = 10L;

        long likes = service.getLikes(postId);
        long comments = service.getComments(postId);

        System.out.println("Post ID: " + postId);
        System.out.println("Likes: " + likes);
        System.out.println("Comments: " + comments);
    }
}
