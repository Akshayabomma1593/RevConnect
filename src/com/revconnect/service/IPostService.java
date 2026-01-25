package com.revconnect.service;

import com.revconnect.model.Post;

import java.util.List;

public interface IPostService {

    void createPostWithHashtags(Post post, List<String> hashtags);
}