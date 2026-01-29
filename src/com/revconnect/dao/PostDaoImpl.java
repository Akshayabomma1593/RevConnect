package com.revconnect.dao;

import com.revconnect.model.Post;
import com.revconnect.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDaoImpl implements IPostDao {

    @Override
    public int createPost(Post post) {

        String sql =
                "INSERT INTO posts (post_id, user_id, content, created_at) " +
                        "VALUES (?, ?, ?, SYSDATE)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, post.getPostId());
            ps.setInt(2, post.getUserId());
            ps.setString(3, post.getContent());

            ps.executeUpdate();
            return post.getPostId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int createOrGetHashtag(String tag) {

        String selectSql =
                "SELECT hashtag_id FROM hashtags WHERE tag = ?";
        String insertSql =
                "INSERT INTO hashtags (hashtag_id, tag) VALUES (hashtags_seq.NEXTVAL, ?)";

        try (Connection con = JDBCUtil.getConnection()) {

            // check if hashtag already exists
            try (PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, tag);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("hashtag_id");
                }
            }

            // insert new hashtag
            try (PreparedStatement ps = con.prepareStatement(insertSql)) {
                ps.setString(1, tag);
                ps.executeUpdate();
            }

            // fetch newly created hashtag id
            try (PreparedStatement ps = con.prepareStatement(selectSql)) {
                ps.setString(1, tag);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("hashtag_id");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void mapPostHashtag(int postId, int hashtagId) {

        String sql =
                "INSERT INTO post_hashtag (post_id, hashtag_id) VALUES (?, ?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, postId);
            ps.setInt(2, hashtagId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}