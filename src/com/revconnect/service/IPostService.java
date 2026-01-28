package com.revconnect.service;

import com.revconnect.model.Post;
import java.util.List;

public interface IPostService {

    /**
     * Create a post and map its hashtags
     * @param post Post object to create
     * @param hashtags List of hashtags to associate with the post
     * @return the postId if created successfully, -1 if failed
     */
    int createPostWithHashtags(Post post, List<String> hashtags);
}
