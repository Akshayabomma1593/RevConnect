package com.revconnect.service;

import com.revconnect.dao.IPostDao;
import com.revconnect.dao.PostDaoImpl;
import com.revconnect.model.Post;

import java.util.List;

public class PostServiceImpl implements IPostService {

    private final IPostDao postDao = new PostDaoImpl();

    @Override
    public void createPostWithHashtags(Post post, List<String> hashtags) {

        int postId = postDao.createPost(post);

        if (postId == -1) {
            System.out.println("Post creation failed");
            return;
        }

        for (String tag : hashtags) {
            int hashtagId = postDao.createOrGetHashtag(tag);
            if (hashtagId != -1) {
                postDao.mapPostHashtag(postId, hashtagId);
            }
        }

        System.out.println("Post created successfully with hashtags!");
    }
}