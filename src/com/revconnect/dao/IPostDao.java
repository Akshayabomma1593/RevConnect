package com.revconnect.dao;

import com.revconnect.model.Post;

import java.util.List;

public interface IPostDao {

    int createPost(Post post);

    int createOrGetHashtag(String tag);

    void mapPostHashtag(int postId, int hashtagId);
}